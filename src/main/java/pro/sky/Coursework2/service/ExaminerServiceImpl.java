package pro.sky.Coursework2.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.Coursework2.exception.QuestionOverlimitException;
import pro.sky.Coursework2.interfaces.ExaminerService;
import pro.sky.Coursework2.interfaces.JavaQuestionService;
import pro.sky.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@Component
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        int size = questionService.getAll().size();
        if (size < amount) {
            throw new QuestionOverlimitException("Лимит вопросов превышен");
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
