package com.idi.examinatoridi;

import com.idi.common.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
@RestController
public class ExamController {


    private Map<String,String> sectionName2Url = new HashMap<>();

    @Autowired
    private RestTemplate restTemplate;

    public ExamController() {

        sectionName2Url.put("math", "http://localhost:8081/");
        sectionName2Url.put("tanah", "http://localhost:8082/");
    }

    /*@Autowired
        public ExamController(List<QuestionGenerator> questionGenerators) {
            Map<String, QuestionGenerator> map = questionGenerators.stream()
                    .collect(Collectors.toMap(QuestionGenerator::sectionName, Function.identity()));
        }
    */
    @PostMapping("/api/exam")
    public Exam calculateExam(@RequestBody Map<String, Integer> examSpec) {
        Exam exam = new Exam();

        for (String sectionName : examSpec.keySet()) {

            Integer amount = examSpec.get(sectionName);
            String url = sectionName2Url.get(sectionName)+"api/questions/random?amount="+amount;
            Question[] questions = restTemplate.getForObject(url, Question[].class);
            exam.addSection(new Section(sectionName,asList(questions)));
        }
        //example of examSpec
        //{"mathematika":6,"tanah":4}
        return exam;
    }
}
