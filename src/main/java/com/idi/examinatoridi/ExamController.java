package com.idi.examinatoridi;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class ExamController {

    @Autowired
    private Map<String,ExerciseGenerator> exerciseGeneratorMap;




    public Exam calculateExam(Map<String, Integer> examSpec) {

        for (String sectionName : examSpec.keySet()) {
            ExerciseGenerator generator = exerciseGeneratorMap.get(sectionName);
            Integer amount = examSpec.get(sectionName);
            List<Question> section = generator.getRandom(amount);
        }
        //example of examSpec
        //{"mathematika":6,"tanah":4}
        return null;
    }
}
