package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstructor to load the student data ... only once!
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();

        students.add(new Student("John", "Doe"));
        students.add(new Student("Max", "Maksin"));
        students.add(new Student("Anna", "K"));
    }

    // define endpoint for "/students" - return list students

    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    // define endpoint for "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list ... keep it simple for now

        // check the studentId against list size
        if (studentId>=students.size()||studentId<0){
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
        return students.get(studentId);
    }



}
