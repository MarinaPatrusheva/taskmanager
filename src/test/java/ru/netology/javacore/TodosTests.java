package ru.netology.javacore;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.Collections;

public class TodosTests {
    private final int LIMIT = 7;
    @org.junit.jupiter.api.Test
    public void getAllTasks(){
        Todos todos = new Todos();
        ArrayList<String> listTaskTest = new ArrayList<>();
        fillInTheList(todos, listTaskTest);
        String test = buildString(listTaskTest);
        Assertions.assertEquals(todos.getAllTasks(), test);
    }
    @org.junit.jupiter.api.Test
    public void addTaskTest(){
        Todos todos = new Todos();
        ArrayList<String> listTaskTest = new ArrayList<>();
        fillInTheList(todos, listTaskTest);
        todos.addTask("!task!");
        String test = buildString(listTaskTest);
        Assertions.assertEquals(todos.getAllTasks(), test.toString());
    }
    @org.junit.jupiter.api.Test
    public void removeTaskTest(){
        Todos todos = new Todos();
        ArrayList<String> listTaskTest = new ArrayList<>();
        fillInTheList(todos, listTaskTest);
     todos.removeTask("task" + 1);
     listTaskTest.remove("task" + 1);
        String test = buildString(listTaskTest);
     Assertions.assertEquals(todos.getAllTasks(), test);
    }
    private void fillInTheList(Todos todos, ArrayList<String> listTaskTest){
        for(int i = 0; i < LIMIT; i++){
            listTaskTest.add("task" + i + 1);
            todos.addTask("task" + i + 1);
        }
    }
    private String buildString(ArrayList<String> listTaskTest){
        StringBuilder builder = new StringBuilder();
        Collections.sort(listTaskTest);
        for(int i = 0; i < listTaskTest.size(); i++){
            builder.append(listTaskTest.get(i));
            builder.append(" ");
        }
        return builder.toString();
    }
}
