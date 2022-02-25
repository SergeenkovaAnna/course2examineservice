package com.example.course2examineservice.questionService;

import com.example.course2examineservice.data.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int getSizeSet();
}
