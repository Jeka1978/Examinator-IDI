package com.idi.examinatoridi;

import org.springframework.web.bind.annotation.*;

/**
 * @author Evgeny Borisov
 */


@RestController
@RequestMapping("/api/")
public class ExampleController {


    @PostMapping("person/upper")
    public Person convertToUpperCase(@RequestBody Person person) {

        person.setName(person.getName().toUpperCase());
        return person;
    }


    @GetMapping("name/{name}")
    public Person getPersonWithName(@PathVariable String name) {
        return new Person(name.toLowerCase());
    }

    @GetMapping("name")
    public Person getPersonWithNameRequestParam(@RequestParam String name) {
        return new Person(name.toUpperCase());
    }

    @GetMapping("person")
    public Person getPerson() {
        return new Person("Andrei");
    }

    @GetMapping("hello")
    public String hello() {

        return "Hello!!!";
    }

}





