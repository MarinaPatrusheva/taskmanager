package ru.netology.javacore.typeofcommand;

import ru.netology.javacore.Todos;

public class typeAdd implements Command {
    private Todos todos;

    public typeAdd(Todos todos) {
        this.todos = todos;
    }

    private final String TYPE = "ADD";

    public String getTYPE() {
        return TYPE;
    }

    @Override
    public String command(String task) {
        todos.addTask(task);
        return todos.getAllTasks();
    }
}
