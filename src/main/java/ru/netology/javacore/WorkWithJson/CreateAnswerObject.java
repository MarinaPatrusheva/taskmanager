package ru.netology.javacore.WorkWithJson;

import com.google.gson.Gson;

public class CreateAnswerObject {
    public String write(Answer answer) {
        Gson gson = new Gson();
        return gson.toJson(answer);
    }
}
