package com.quikapp.test.assembler;

import com.quikapp.test.entity.StudentEntity;
import com.quikapp.test.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentAssembler {
    public Student assembleStudentEntity(StudentEntity studentEntity){
        Student student = new Student();
        student.setName(studentEntity.getName());
        student.setNic(studentEntity.getNic());
        student.setAge(studentEntity.getAge());
        return student;
    }
    public StudentEntity assembleStudentModel(Student student){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setNic(student.getNic());
        studentEntity.setAge(student.getAge());
        return studentEntity;
    }
}
