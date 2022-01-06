package com.idi.examinatoridi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@RestController
public class ExamController {

    @Autowired
    private Map<String,QuestionGenerator> questionsGeneratorMap;




    @PostMapping("/api/exam")
    public Exam calculateExam(@RequestBody Map<String, Integer> examSpec) {
        Exam exam = new Exam();

        for (String sectionName : examSpec.keySet()) {
            QuestionGenerator generator = questionsGeneratorMap.get(sectionName);
            Integer amount = examSpec.get(sectionName);
            List<Question> questions = generator.getRandomQuestions(amount);
            exam.addSection(new Section(sectionName,questions));
        }
        //example of examSpec
        //{"mathematika":6,"tanah":4}
        return exam;
    }
}
