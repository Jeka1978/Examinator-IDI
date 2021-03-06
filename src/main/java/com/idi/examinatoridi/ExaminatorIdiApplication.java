package com.idi.examinatoridi;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableAsync
public class ExaminatorIdiApplication {


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    @LoadBalanced
    public RestTemplate idiRestTemplate(RestTemplateBuilder builder){

        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }

    @Bean
    @Primary
    public RestTemplate restTemplate(RestTemplateBuilder builder){

        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(new Person());
        ConfigurableApplicationContext context = SpringApplication.run(ExaminatorIdiApplication.class, args);
        System.out.println();
    }

}
