package ru.netology.javacore.WorkWithJson;

import com.google.gson.Gson;

public class GetAnswerObject {
    public Answer read(String request) {
        Gson gson = new Gson();
        Answer answer = gson.fromJson(request, Answer.class);
        return answer;
    }
}
