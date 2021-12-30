package com.idi.examinatoridi;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface ExerciseGenerator {

    List<Question> getRandom(int amount);
}
