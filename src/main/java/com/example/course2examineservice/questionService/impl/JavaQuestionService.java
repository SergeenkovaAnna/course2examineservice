package com.example.course2examineservice.questionService.impl;

import com.example.course2examineservice.data.Question;
import com.example.course2examineservice.exceptions.NotFoundQuestionException;
import com.example.course2examineservice.exceptions.QuestionAlreadyExistException;
import com.example.course2examineservice.questionService.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question addNewQuestion = new Question(question, answer);
        return add(addNewQuestion);
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionAlreadyExistException();
        }
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question deleteQuestion = new Question(question, answer);
        if (!questions.remove(deleteQuestion)) {
            throw new NotFoundQuestionException();
        }
        return remove(question, answer);
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questions).get(random.nextInt(questions.size()));
    }

    @Override
    public int getSizeSet() {
        return questions.size();
    }


}
