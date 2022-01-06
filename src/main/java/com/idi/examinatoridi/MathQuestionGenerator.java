package com.idi.examinatoridi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Service("math")
public class MathQuestionGenerator implements QuestionGenerator {
    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        int answer = a+b;
        return Question.builder().question(a+" + "+b+" =?").answer(String.valueOf(answer)).build();
    }

    @Override
    public List<Question> getRandomQuestions(int amount) {
        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            questions.add(getRandomQuestion());

        }
        return questions;
    }
}



