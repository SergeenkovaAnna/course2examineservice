package com.example.course2examineservice.questionService.impl;

import com.example.course2examineservice.data.Question;
import com.example.course2examineservice.exceptions.NotFoundQuestionException;
import com.example.course2examineservice.exceptions.QuestionAlreadyExistException;
import com.example.course2examineservice.questionService.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Collection;
import java.util.Set;

import static com.example.course2examineservice.questionService.impl.JavaQuestionServiceConstsntForTest.*;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private QuestionService out;

    @BeforeEach
    public void startNew() {
        out = new JavaQuestionService();
    }

    @Test
    void addQuestionByParameters() {
        Question expectedQuestion = new Question(QUESTION_1, ANSWER_1);
        Question questionActual = out.add(QUESTION_1, ANSWER_1);
        assertEquals(expectedQuestion, questionActual);
    }

    @Test
    void addQuestionAsObject() {
        Question expectedQuestion = new Question(QUESTION_1, ANSWER_1);
        assertEquals(expectedQuestion, out.add(expectedQuestion));
    }

    @Test
    void addQuestionAlreadyExistException() {
        Question questionActual = new Question(QUESTION_1, ANSWER_1);
        out.add(questionActual);
        assertThrows(QuestionAlreadyExistException.class, () -> out.add(questionActual));
    }

    @Test
    void removeQuestionTest() {
        Question questionActual = out.add(QUESTION_1, ANSWER_1);
        assertEquals(questionActual, out.remove(QUESTION_1, ANSWER_1));
    }

    @Test
    void removeQuestionNotFoundQuestionException() {
        assertThrows(NotFoundQuestionException.class, () -> out.remove(QUESTION_1, ANSWER_1));
    }

    @Test
    void getAllQuestionsTest() {
        assertEquals(0, out.getAll().size());
        Question questionActual_1 = out.add(QUESTION_1, ANSWER_1);
        Question questionActual_2 = out.add(QUESTION_2, ANSWER_2);
        Collection<Question> allQuestions = out.getAll();
        Collection<Question> expectedQuestions = Set.of(questionActual_1, questionActual_2);
        assertTrue(expectedQuestions.containsAll(allQuestions) && allQuestions.containsAll(expectedQuestions) && allQuestions.size() == expectedQuestions.size());
    }

}
