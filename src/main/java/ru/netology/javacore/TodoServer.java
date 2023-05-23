package ru.netology.javacore;

import ru.netology.javacore.WorkWithJson.Answer;
import ru.netology.javacore.WorkWithJson.GetAnswerObject;
import ru.netology.javacore.typeofcommand.SetCommand;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private final int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port)
        ) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
                    SetCommand command = new SetCommand(todos);
                    GetAnswerObject answerObject = new GetAnswerObject();
                    Answer answer = answerObject.read(in.readLine());
                    out.print(command.setCommand(answer.getType(), answer.getTask()));
                    out.flush();
                }
            }
        }
    }
}
