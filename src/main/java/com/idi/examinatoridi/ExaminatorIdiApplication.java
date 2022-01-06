package com.idi.examinatoridi;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class ExaminatorIdiApplication {



    @Bean
    public RestTemplate idiRestTemplate(RestTemplateBuilder builder){

        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(new Person());
        SpringApplication.run(ExaminatorIdiApplication.class, args);
    }

}
