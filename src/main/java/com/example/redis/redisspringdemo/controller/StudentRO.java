package com.example.redis.redisspringdemo.controller;

import com.example.redis.redisspringdemo.entity.Student.Gender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentRO {

    private String name;
    private Gender gender;
    private int grade;

    
    @Override
    public String toString() {
        return "StudentRO [gender=" + gender + ", grade=" + grade + ", name=" + name + "]";
    }
    
    

}
