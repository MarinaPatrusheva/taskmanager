package ru.netology.javacore.WorkWithJson;

public class Answer {
    private String type;
    private String task;
    public Answer(String type, String task){
        this.type = type;
        this.task = task;
    }
    public String getType(){
        return type;
    }
    public String getTask(){
        return task;
    }
}
