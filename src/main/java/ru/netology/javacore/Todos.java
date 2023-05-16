package ru.netology.javacore;

import java.util.ArrayList;
import java.util.Collections;

public class Todos {
    private final int LIMIT_TASK = 7;
    private ArrayList<String> taskArray = new ArrayList<>();
    private ArrayList<String> lastTaskArray = new ArrayList<>();
    public void addTask(String task) {
        if(taskArray.size() < LIMIT_TASK){
           copyList(lastTaskArray, taskArray);
           taskArray.add(task);
        }
    }
    public void removeTask(String task) {
        copyList(lastTaskArray, taskArray);
        taskArray.remove(task);
        }
        public void restore(){
            copyList(taskArray, lastTaskArray);
        }

    public String getAllTasks() {
        StringBuilder builder = new StringBuilder();
        Collections.sort(taskArray);
        for(int i = 0; i < taskArray.size(); i++){
            builder.append(taskArray.get(i));
            builder.append(" ");
        }
        return builder.toString();
    }
    private ArrayList<String> copyList(ArrayList<String> listOne, ArrayList<String> listTwo){
            listOne.removeAll(listOne);
        for(int i = 0; i < listTwo.size(); i++){
            listOne.add(listTwo.get(i));
        }
        return listOne;
    }
}
