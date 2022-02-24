package com.example.course2examineservice.qustionService;

import com.example.course2examineservice.data.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int getSizeSet();
}
