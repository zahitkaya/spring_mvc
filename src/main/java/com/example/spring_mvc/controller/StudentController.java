package com.example.spring_mvc.controller;
//classta farklı jsonda farklı
//jsonpropert, jsonignore
import com.example.spring_mvc.model.Student;
import com.example.spring_mvc.service.StudentService;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class StudentController {
    StudentService studentService = new StudentService();


    @GetMapping(value = "/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping(value = "/students")
    public Student postStudents(@RequestBody Student student) {
        return student;
    }

    @PostMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/student/{id}/{name}/{adress}/{gpa}")
    public Student addNewStudent(@PathVariable int id, @PathVariable String name,
                                 @PathVariable String adress, @PathVariable Double gpa) {
        Student student = Student.builder().id(id).adress(adress).name(name).gpa(gpa).build();
        return studentService.addStudent(student);
    }

    @PutMapping("/student/{id}/{name}/{adress}/{gpa}")
    public Student updateStudent(@PathVariable int id, @PathVariable String name,
                                 @PathVariable String adress, @PathVariable Double gpa) {
        Student student = Student.builder().id(id).adress(adress).name(name).gpa(gpa).build();
        return studentService.updateStudent(student);
    }

    @GetMapping("/requestparam")
    @ResponseBody
    public String paramExample(@RequestParam(defaultValue = "Varsayılan isim") String name
            , @RequestParam(required = false) String surname) {
        return "İsim: " + name + " Soyisim " + surname;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "File doesnt exist")
    @GetMapping("/error")
    public String getError() {
        return "ERROR";
    }

    @GetMapping("deneme")
    public String deneme(@RequestHeader(value = "name", defaultValue = "Varsayılan değer") String value) {
        return "İsim: " + value;
    }


    @GetMapping("/header1")
    public String usingHttpServletResponse(HttpServletResponse response,
                                           @RequestHeader(value = "value", defaultValue = "varsayılan") String value) {
        response.addHeader("Header1 ", "Value1");
        return "servletResponse kullanarak header1 eklendi" + value;
    }

    @GetMapping("/header2")
    public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders(@RequestHeader(value = "value", defaultValue = "varsayılan")
                                                                                   String value) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Header2",
                "Value-Header2");

        try {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body("ResponseEntity kullanarak header2 ekledik " + value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @GetMapping("filter")
    String getStudentss() throws JsonProcessingException {
        Student student = new Student("Ali",2,"Merkez",2.1);
        ObjectMapper mapper = new ObjectMapper();
        FilterProvider filters = new SimpleFilterProvider() .addFilter(
                "nameFilter", SimpleBeanPropertyFilter.filterOutAllExcept("adress","id"));
        String jsonString = mapper.writer(filters)
                .withDefaultPrettyPrinter()
                .writeValueAsString(student);
        return jsonString;
    }
   /*
    @GetMapping("jsonvalue")
    String getValue(){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            Student student = new Student("Ali",2,"Merkez",2.1);
             jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(student);
            System.out.println(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
    */
    @GetMapping("include")
    public Student includeTest(){
        Student student=Student
                .builder()
                .name(null)
                .adress("{\"doorNumber\": 1118, \"street\": IDPL Colony,\"city\":\"Hyderabad\"}").build();
        return student;
    }
    @GetMapping("jsonvalue")
    public Student testValue(){
        Student student=Student
                .builder()
                .gpa(2.5)
                .id(6)
                .adress("yeni mahalle")
                .name("Ayşe")
                .build();
        return student;
    }
    @GetMapping("getterTest")
    public Student testJsonGetter(){
        Student student=Student.builder().name("Mustafa").adress("Kümbet").gpa(2.1).id(12).build();
        return student;
    }

}
