package com.example.course2examineservice.qustionService;

import com.example.course2examineservice.data.Question;
import com.example.course2examineservice.exceptions.NotFoundQuestionException;
import com.example.course2examineservice.exceptions.QuestionAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements  QuestionService{

    private final Set<Question> questions = new HashSet<>();

    private final Random random = new Random();

//    public JavaQuestionService(Set<Question> questions) {
//        this.questions = new LinkedHashSet<>();
//    }

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
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new NotFoundQuestionException();
        }
        return question;
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
