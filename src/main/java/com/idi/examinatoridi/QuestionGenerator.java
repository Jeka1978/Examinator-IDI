package com.idi.examinatoridi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface QuestionGenerator {
    Question getRandomQuestion();

    List<Question> getRandomQuestions(int amount);
}




