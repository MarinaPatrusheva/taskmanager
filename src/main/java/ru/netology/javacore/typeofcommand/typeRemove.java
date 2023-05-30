package ru.netology.javacore.typeofcommand;

import ru.netology.javacore.Todos;

public class typeRemove implements Command {
    private Todos todos;

    public typeRemove(Todos todos) {
        this.todos = todos;
    }

    private final String TYPE = "REMOVE";

    public String getTYPE() {
        return TYPE;
    }

    @Override
    public String command(String task) {
        todos.removeTask(task);
        return todos.getAllTasks();
    }
}
