package com.example.course2examineservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundQuestionException extends RuntimeException {
    public NotFoundQuestionException() {
        super("Такой вопрос не найден!");
    }
}
