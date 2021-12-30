package com.idi.examinatoridi;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExaminatorIdiApplication {

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(new Person());
        SpringApplication.run(ExaminatorIdiApplication.class, args);
    }

}
