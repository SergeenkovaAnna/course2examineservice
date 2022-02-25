package com.example.course2examineservice.questionService.impl;

import com.example.course2examineservice.data.Question;
import com.example.course2examineservice.exceptions.BadRequestException;
import com.example.course2examineservice.questionService.ExaminerService;
import com.example.course2examineservice.questionService.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;


    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestion(int amount) {
        int size = questionService.getSizeSet();
        if (amount > size || 0 > amount) {
            throw new BadRequestException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
