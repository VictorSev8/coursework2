package pro.sky.Coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.Coursework2.exception.NotFoundException;
import pro.sky.Coursework2.interfaces.JavaQuestionService;
import pro.sky.model.Question;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements JavaQuestionService {

    private final Random random = new Random();
    private final Set<Question> javaQuestion = new LinkedHashSet<>();


    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        javaQuestion.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (javaQuestion.contains(question)) {
            javaQuestion.remove(question);
            return question;
        }
        throw new NotFoundException("Вопрос не найден");
    }

    @Override
    public Collection<Question> getAll(){
        List<Question> list = new ArrayList<>(javaQuestion);
        return list;
    }
    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(javaQuestion);
        int numb = random.nextInt(getAll().size());
        return list.get(numb);
    }
}