package com.example.course2examineservice.controller;

import com.example.course2examineservice.data.Question;
import com.example.course2examineservice.questionService.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("add")
        public String addQuestion(@RequestParam String question,
                                  @RequestParam String answer) {
        Question result = service.add(question, answer);
        return message(result, "вопрос и ответ успешно добавлен");
    }

    @GetMapping("remove")
    public String removeQuestion(@RequestParam String question,
                                 @RequestParam String answer) {
        Question result = service.remove(question, answer);
        return message(result, "вопрос и ответ успешно удален");
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }


    private String message(Question question, String status) {
        return String.format(question.getQuestion(), question.getAnswer(), status);
    }
}
