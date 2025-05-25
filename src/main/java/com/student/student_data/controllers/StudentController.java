package com.student.student_data.controllers;

import com.student.student_data.entity.Student;
import com.student.student_data.repository.StudentRepository;
import com.student.student_data.services.StudentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** RestController > includes @Controller @ResponseBody **/
@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentDataService studentDataService;

    @GetMapping("/students")
    public List<Student> getStudent() {
        return studentDataService.getStudentDetail();
    }

    @GetMapping("/student/{Id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("Id") long studentId){
        return new ResponseEntity<Student>(studentDataService.getStudentById(studentId), HttpStatus.OK);
    }

    @PostMapping("/create-student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentDataService.createStudent(student), HttpStatus.CREATED) ;
    }

    @DeleteMapping("/delete-student/{Id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("Id") long studentId){
        studentDataService.deleteStudentById(studentId);
        return new ResponseEntity<String>("Student deleted suucessfully", HttpStatus.OK);
    }

    @PutMapping("/update-student/{id}")
    public ResponseEntity<Student> updateStudentById(@RequestBody Student student, @PathVariable("id") long id){
        return new ResponseEntity<Student>(studentDataService.updateStudent(student, id), HttpStatus.OK);
    }
}
