package com.idi.examinatoridi;

import com.idi.common.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
@RestController
public class ExamController {


    @Autowired
    private DiscoveryClient discoveryClient;



    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;


    /*@Autowired
        public ExamController(List<QuestionGenerator> questionGenerators) {
            Map<String, QuestionGenerator> map = questionGenerators.stream()
                    .collect(Collectors.toMap(QuestionGenerator::sectionName, Function.identity()));
        }
    */
    @PostMapping("/api/exam")
    public Exam calculateExam(@RequestBody Map<String, Integer> examSpec) {
        Exam exam = new Exam();

        for (String sectionName : examSpec.keySet()) {

          /*  List<ServiceInstance> instances = discoveryClient.getInstances(sectionName);
            instances.get(0).getUri()*/

            Integer amount = examSpec.get(sectionName);
            String url = "http://"+sectionName+"/api/questions/random?amount="+amount;
            Question[] questions = restTemplate.getForObject(url, Question[].class);
            exam.addSection(new Section(sectionName,asList(questions)));
        }
        //example of examSpec
        //{"mathematika":6,"tanah":4}
        return exam;
    }
}
