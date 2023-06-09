package pro.sky.Coursework2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Coursework2.exception.QuestionOverlimitException;
import pro.sky.Coursework2.interfaces.ExaminerService;
import pro.sky.model.Question;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private JavaQuestionServiceImpl questionService;

    @InjectMocks
    private ExaminerService examinerService;
    private Set<Question> questionSet;
    @BeforeEach
    public void beforeEach(){
        questionSet = Set.of(
                new Question("question1","answer1"),
                new Question("question2","answer2"),
                new Question("question3","answer3")
        );
        Mockito.when(questionService.getAll()).thenReturn(questionSet);
    }

    @Test
    public void getQuestionTest(){
//       Set<Question> expected = Set.of(new Question("question1","answer1"),
//               new Question("question2","answer2"),
//               new Question("question3","answer3"));
        Assertions.assertThrows(QuestionOverlimitException.class,()->examinerService.getQuestion(2));

    }

}
