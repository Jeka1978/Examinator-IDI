package com.idi.examinatoridi;

import com.idi.common.model.Question;
import lombok.*;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Section {
    private String title;
    private List<Question> questions;


}
