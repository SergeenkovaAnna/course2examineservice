package com.example.course2examineservice.controller;

import com.example.course2examineservice.data.Question;
import com.example.course2examineservice.qustionService.ExaminerService;
import com.example.course2examineservice.qustionService.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestion(@PathVariable int amount) {
        return examinerService.getQuestion(amount);
    }
//        Question result = examinerService.getQuestion(amount);
//        return message(result, "список вопросов и ответов ниже");
//    }
//
//
//    private String message(Question question, String status) {
//        return String.format(question.getQuestion(), question.getAnswer(), status);
//    }

}
