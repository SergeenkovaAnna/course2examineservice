package com.example.course2examineservice.questionService.impl;

import com.example.course2examineservice.data.Question;
import com.example.course2examineservice.exceptions.BadRequestException;
import com.example.course2examineservice.questionService.ExaminerService;
import com.example.course2examineservice.questionService.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.example.course2examineservice.questionService.impl.JavaQuestionServiceConstsntForTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private ExaminerServiceImpl out;

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    Question questionActual_1 = new Question(QUESTION_1, ANSWER_1);
    Question questionActual_2 = new Question(QUESTION_2, ANSWER_2);
    Question questionActual_3 = new Question(QUESTION_3, ANSWER_3);
    Question questionActual_4 = new Question(QUESTION_4, ANSWER_4);
    Question questionActual_5 = new Question(QUESTION_5, ANSWER_5);
    Question questionActual_6 = new Question(QUESTION_6, ANSWER_6);

    @BeforeEach
    public void startNew() {
        Collection<Question> allQuestions = Set.of(questionActual_1, questionActual_2, questionActual_3, questionActual_4, questionActual_5, questionActual_6);
        when(out.getQuestion(6)).thenReturn(allQuestions);
    }

    @Test
    void illegalAmount() {
        assertThrows(BadRequestException.class, () -> out.getQuestion(0));
        assertThrows(BadRequestException.class, () -> out.getQuestion(-2));
    }

    @Test
    void getQuestionForExam() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2),
                new Question(QUESTION_3, ANSWER_3),
                new Question(QUESTION_4, ANSWER_4),
                new Question(QUESTION_5, ANSWER_5));

        Collection<Question> actual = out.getQuestion(5);
        List<Question> expected = List.of(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2),
                new Question(QUESTION_3, ANSWER_3),
                new Question(QUESTION_4, ANSWER_4),
                new Question(QUESTION_5, ANSWER_5));
        assertEquals(expected, actual);
    }

}
