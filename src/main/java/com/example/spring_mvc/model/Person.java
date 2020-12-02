package com.example.spring_mvc.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"name","lastName"})
public class Person {

    /*private String name;
    private String lastName;
    public int id;

     */
 /* @JsonIgnoreType
    private Address address;
    @Data
    @AllArgsConstructor
    public static class Address{
        String street;
        int doorNumber;
    }

  */

}
