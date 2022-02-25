package com.example.course2examineservice.controller;

import com.example.course2examineservice.data.Question;
import com.example.course2examineservice.questionService.ExaminerService;
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

}
