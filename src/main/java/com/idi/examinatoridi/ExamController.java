package com.idi.examinatoridi;

import com.idi.common.model.Question;
import lombok.SneakyThrows;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
@RestController
public class ExamController {

    @Autowired
    private ExamService examService;





    @PostMapping("/api/rabbit/exam")
    public String requestForExam(@RequestBody Map<String, Integer> examSpec) {
        Exam exam = examService.prepareExam(examSpec);

//        template.convertAndSend("ecxchangeName","routing key",exam);

        return "OK";
    }


    @PostMapping("/api/exam")
    public Exam calculateExam(@RequestBody Map<String, Integer> examSpec) {
        //example of examSpec
        //{"mathematika":6,"tanah":4}
        return examService.prepareExam(examSpec);
    }


}
