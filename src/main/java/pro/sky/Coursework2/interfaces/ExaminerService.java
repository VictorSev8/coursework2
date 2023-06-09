package pro.sky.Coursework2.interfaces;

import pro.sky.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}
