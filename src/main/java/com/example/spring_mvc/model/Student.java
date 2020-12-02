package com.example.spring_mvc.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
//@JsonFilter("nameFilter")
//@JsonPropertyOrder({"id","ad","adress","Ortalama"})
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonRootName(value = "student")
    public class Student {
        @JsonProperty("ad")
        String name;
        int id;
        @JsonRawValue
        String adress;
        @JsonProperty("Ortalama")
        double gpa;

    @JsonGetter("get-id")
    public int getId() {
        return id;
    }


/*
        @JsonValue
        public String getStudentInfo(){
            return name+" - "+id+" - "+adress+" - "+ gpa;
        }

 */
}
