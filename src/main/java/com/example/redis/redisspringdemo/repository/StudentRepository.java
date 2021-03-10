package com.example.redis.redisspringdemo.repository;

import com.example.redis.redisspringdemo.entity.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    
}
