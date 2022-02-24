package com.example.course2examineservice.qustionService;

import com.example.course2examineservice.data.Question;

import java.util.Collection;

public interface ExaminerService {
    //тут должен лежать сет из вопросов, к которому обращается ExamController и возвращает их пользователю
    Collection<Question> getQuestion(int amount);
}
