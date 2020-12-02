package com.example.spring_mvc.controller;

import com.example.spring_mvc.model.Person;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PersonController {


    /*
    @GetMapping("ignoreProperties")
    public Person getAutoDetected(){
        Person person= Person.builder().name("Zahit").lastName("Kaya").id(21).build();
        return person;
    }

     */

    /*
    @GetMapping("/ignoreType")
    public Person getIgnore(){
        Person.Address address=new Person.Address("Gazi caddesi",2);
        Person person= Person.builder().address(address).id(5).name("Mehmet").build();
        return person;
    }

     */
}
