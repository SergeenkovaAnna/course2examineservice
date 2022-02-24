package com.example.course2examineservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class QuestionAlreadyExistException extends RuntimeException {
    public QuestionAlreadyExistException() {
        super("Такой вопрос уже существует!");
    }
}
