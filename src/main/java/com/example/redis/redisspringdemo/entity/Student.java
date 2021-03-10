package com.example.redis.redisspringdemo.entity;

import com.example.redis.redisspringdemo.controller.StudentRO;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@RedisHash("Student")
public class Student {

    public enum Gender { 
        MALE, FEMALE
    }

    private String id;
    private String name;
    private Gender gender;
    private int grade;

    public Student update(StudentRO update){
        this.name = update.getName();
        this.gender = update.getGender();
        this.grade = update.getGrade();
        return this;
    }

    @Override
    public String toString() {
        return "Student [gender=" + gender + ", grade=" + grade + ", id=" + id + ", name=" + name + "]";
    }
    
}
