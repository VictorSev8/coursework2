package pro.sky.Coursework2.interfaces;

import pro.sky.model.Question;

import java.util.Collection;

public interface JavaQuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}