package com.idi.examinatoridi;

import com.idi.common.model.Question;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
@Service
public class ExamPrinter {


    @RabbitListener(queues = "examsQueue")
    public void printExamFromQueue(Exam exam) {
        System.out.println(exam);
    }


}
