package com.example.spring_mvc.service;

import com.example.spring_mvc.model.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class StudentService {

    private static HashMap<Integer, Student> studentHashMap = new HashMap<Integer, Student>();

    public StudentService() {

        studentHashMap = new HashMap<Integer, Student>();
        Student student1 = Student.builder().adress("Fatih").gpa(2.5).id(1).name("Zahit").build();
        Student student2 = Student.builder().adress("Aydoğan").gpa(2.5).id(2).name("Murat").build();

        studentHashMap.put(1, student1);
        studentHashMap.put(2,student2);


    }
    public static int getMaximumId() {
        int max = 0;
        for (int id : studentHashMap.keySet()) {
            if (max <= id) {
                max = id;
            }
        }
        return max;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>(studentHashMap.values());
        return students;
    }
    public Student getStudent(int id){
        return studentHashMap.get(id);
    }
    public void deleteStudent(int id){
        studentHashMap.remove(id);
    }
    public Student addStudent(Student student){
        student.setId(getMaximumId()+1);
        studentHashMap.put(student.getId(),student);
        return student;
    }
    public Student updateStudent(Student student){
        studentHashMap.put(student.getId(),student);
        return student;
    }

}
