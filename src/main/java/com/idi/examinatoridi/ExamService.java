package com.idi.examinatoridi;

import com.idi.common.model.Question;
import lombok.SneakyThrows;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
@Service
public class ExamService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    private AmqpTemplate template;


    @SneakyThrows
    @Async
    public Exam prepareExam(Map<String, Integer> examSpec) {
        Thread.sleep(3000);
        Exam exam = new Exam();

        for (String sectionName : examSpec.keySet()) {

          /*  List<ServiceInstance> instances = discoveryClient.getInstances(sectionName);
            instances.get(0).getUri()*/

            Integer amount = examSpec.get(sectionName);
            String url = "http://" + sectionName + "/api/questions/random?amount=" + amount;
            Question[] questions = restTemplate.getForObject(url, Question[].class);
            exam.addSection(new Section(sectionName, asList(questions)));
        }
        template.convertAndSend(exam);
        return exam;
    }
}
