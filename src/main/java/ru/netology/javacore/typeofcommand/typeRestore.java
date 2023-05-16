package ru.netology.javacore.typeofcommand;

import ru.netology.javacore.Todos;

public class typeRestore implements CommandWithoutParameters{
    private final String TYPE = "RESTORE";
    private Todos todos;
    public typeRestore(Todos todos){
        this.todos = todos;
    }
    public String command() {
        todos.restore();
        return todos.getAllTasks();
    }

    public String getTYPE() {
        return TYPE;
    }
}
