package com.quikapp.test.rest.controller;

import com.quikapp.test.model.Student;
import com.quikapp.test.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<?> student(){
        return new ResponseEntity<>("<h1>Student</1>", HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id){
        if(studentService.existStudent(id)){
            Student student = studentService.getStudent(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("student not found in database", HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        if(!studentService.existStudent(student.getNic())){
            studentService.addStudent(student);
            return new ResponseEntity<>("student added to database successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("student already exists", HttpStatus.OK);
        }
    }
    @PutMapping("/{nic}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable String nic){
        if(studentService.existStudent(nic)){
            Student updatedStudent = studentService.updateStudent(student,nic);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("student not exists", HttpStatus.OK);
        }
    }
    @DeleteMapping ("/{nic}")
    public ResponseEntity<?> deleteStudent(@PathVariable String nic){
        if(studentService.existStudent(nic)){
            Student deletedStudent = studentService.deleteStudent(nic);
            return new ResponseEntity<>(deletedStudent, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("student not exists", HttpStatus.OK);
        }
    }


}
