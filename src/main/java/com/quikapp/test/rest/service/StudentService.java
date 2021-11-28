package com.quikapp.test.rest.service;

import com.quikapp.test.repository.StudentRepository;
import com.quikapp.test.assembler.StudentAssembler;
import com.quikapp.test.entity.StudentEntity;
import com.quikapp.test.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentAssembler studentAssembler;

    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll().stream()
                .map(studentEntity -> studentAssembler.assembleStudentEntity(studentEntity)).collect(Collectors.toList());
        return studentList;
    }

    public Student getStudent(Long id) {
        StudentEntity studentEntity = studentRepository.getById(id);
        return studentAssembler.assembleStudentEntity(studentEntity);
    }
    public boolean existStudent(Long id){
        return studentRepository.existsById(id);
    }
    public boolean existStudent(String nic){
        return studentRepository.existsByNic(nic);
    }

    public void addStudent(Student student) {
        StudentEntity studentEntity = studentAssembler.assembleStudentModel(student);
        studentRepository.save(studentEntity);
    }

    public Student updateStudent(Student student, String nic) {
        StudentEntity studentEntity = studentRepository.getByNic(nic);
        studentEntity.setName(student.getName());
        studentEntity.setNic(student.getNic());
        studentEntity.setAge(student.getAge());
        studentRepository.save(studentEntity);
        return studentAssembler.assembleStudentEntity(studentEntity);
    }

    public Student deleteStudent(String nic) {
        StudentEntity studentEntity = studentRepository.getByNic(nic);
        studentRepository.delete(studentEntity);
        return studentAssembler.assembleStudentEntity(studentEntity);
    }
}
