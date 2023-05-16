package ru.netology.javacore;

import ru.netology.javacore.WorkWithJson.Answer;
import ru.netology.javacore.WorkWithJson.CreateAnswerObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private final static int PORT = 8989;
    private final static String LOCALHOST = "127.0.0.1";
    public static void main(String[] args){
        try(Socket socket = new Socket(LOCALHOST, PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in)){
            System.out.println("Список доступных команд :");
            System.out.println("ADD + 'В это поле введите событие, которое хотите добавить в список'");
            System.out.println("REMOVE + 'В это поле введите событие, которое хотите удалить'");
            System.out.println("RESTORE - для отмены последней операции");
            CreateAnswerObject object = new CreateAnswerObject();
            String stringRequest = scanner.nextLine();
            String[] answerArray;
            if(stringRequest.contains(" ")){
                answerArray = stringRequest.split(" ", 2);
            }else{
                answerArray = new String[]{stringRequest, null};
            }
            out.println(object.write(new Answer(answerArray[0], answerArray[1])) + "\n");
            out.flush();
            System.out.println(in.readLine());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
