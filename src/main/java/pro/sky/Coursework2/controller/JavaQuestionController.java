package pro.sky.Coursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Coursework2.interfaces.JavaQuestionService;
import pro.sky.model.Question;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")
    public Question javaQuestionAdd(@RequestParam(required = false, value = "question") String question,
                                    @RequestParam(required = false,value = "answer") String answer){
        return javaQuestionService.add(question,answer);
    }

    @GetMapping(path = "/remove")
    public Question javaQuestionRemove(@RequestParam(required = false,value = "question") String question,
                                       @RequestParam(required = false,value = "answer")String answer){
        return javaQuestionService.remove(new Question(question,answer));
    }

    @GetMapping(path = "/exam/java")
    public Collection<Question> javaQuestionPrint(){
        return javaQuestionService.getAll();
    }


}