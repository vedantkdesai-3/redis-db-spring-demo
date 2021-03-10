package com.example.redis.redisspringdemo.controller;


import java.util.ArrayList;
import java.util.List;

import com.example.redis.redisspringdemo.entity.Student;
import com.example.redis.redisspringdemo.repository.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/student")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/loadAll")
    public List<Student> loadAllStudent(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        logger.debug("Students = "+students);
        return students;
    }

    @GetMapping("/{studentId}")
    public @ResponseBody Student findById(@PathVariable("studentId") String studentId){
       logger.debug("studentId ==== >>> "+studentId);
       return studentRepository.findById(studentId).orElse(new Student());
    }


    @PutMapping("/{studentId}")
    public @ResponseBody Student update(@RequestBody StudentRO studentRO, @PathVariable String studentId){
        logger.debug("Student ID "+ studentId +"Request Object ==== >>> "+studentRO);
        Student fetchedObject = studentRepository.findById(studentId).orElseThrow(NullPointerException::new);
        return studentRepository.save(fetchedObject.update(studentRO));
    }


    @DeleteMapping("/{studentId}")
    public void deleteById(@PathVariable("studentId") String studentId){
        studentRepository.deleteById(studentId);
    }


    @PostMapping
    public Student addStudent(@RequestBody Student student){
        logger.info("Student : "+student);
        return studentRepository.save(student);
    }


    @RequestMapping("/welcome")
	public String welcomepage() {
		return "Welcome to Vedant Desai";
	}


    
    
}
