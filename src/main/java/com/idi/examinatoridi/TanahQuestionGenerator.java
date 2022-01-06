package com.idi.examinatoridi;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Evgeny Borisov
 */
@Service("tanah")
public class TanahQuestionGenerator implements QuestionGenerator {

    private List<Question> questions = new ArrayList<>(List.of(
            Question.builder().question("What is the purpose of life").answer("42").build(),
            Question.builder().question("Who said to whom").answer("Moshe").build()
    ));


    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int i = random.nextInt(questions.size());
        return questions.get(i);
    }

    @Override
    public List<Question> getRandomQuestions(int amount) {
        Collections.shuffle(questions);
        return questions.subList(0,amount);
    }
}






