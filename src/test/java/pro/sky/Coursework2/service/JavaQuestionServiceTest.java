package pro.sky.Coursework2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Coursework2.exception.NotFoundException;
import pro.sky.Coursework2.interfaces.JavaQuestionService;
import pro.sky.model.Question;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionServiceTest(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @BeforeEach
    public void beforeEach() {
        javaQuestionService.add("question1", "answer1");
        javaQuestionService.add("question2", "answer2");
        javaQuestionService.add("question3", "answer3");
    }

    @AfterEach
    public void afterEach() {
        javaQuestionService.getAll().forEach(question -> javaQuestionService.remove(question));
    }

    @Test
    public void QuestionAddTest() {
        Question expected = new Question("question4", "answer4");
        Assertions.assertThat(javaQuestionService.add("question4", "answer4"))
                .isEqualTo(expected).isIn(javaQuestionService.getAll());
    }

    @Test
    public void QuestionRemoveTest() {
        Question actual = new Question("question3", "answer3");
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> javaQuestionService.remove(actual));
    }

    @Test
    public void QuestionNegativeRemoveTest() {
        Question actual = new Question("question5", "answer5");
        assertThrows(NotFoundException.class, () -> javaQuestionService.remove(actual));
    }

    @Test
    public void QuestionGetAll() {
        Assertions.assertThat(javaQuestionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(new Question("question1", "answer1"),
                        new Question("question2", "answer2"),
                        new Question("question3", "answer3")
                );
    }


}
