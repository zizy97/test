package com.quikapp.test;

import com.quikapp.test.entity.StudentEntity;
import com.quikapp.test.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;
    @Test
    public void save(){
        StudentEntity studentEntity = new StudentEntity("Sasindu","971000465V",24);
        studentRepository.save(studentEntity);
    }
    @Test
    public void get(){
//        StudentEntity sasindu = studentRepository.getById(2L);
        StudentEntity supun = studentRepository.getStudent(2L,"sasindu");
        System.out.println(supun);
    }
}