package com.student.student_data.services;

import com.student.student_data.entity.Student;
import com.student.student_data.exception.DuplicateRecordException;
import com.student.student_data.exception.ResourceNotFoundException;
import com.student.student_data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDataService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudentDetail(){
       return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        if(studentRepository.existsByName(student.getName())){
            throw new DuplicateRecordException("Student with this name already exists.");
        }
        return studentRepository.save(student);
    }

    public Student getStudentById(long id){
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student","Id",id));
    }

    public void deleteStudentById(long id){
        studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student","Id",id));

        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student, long id){
        // we need to check if student exist
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student","Id",id));

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());

        studentRepository.save(existingStudent);

        return existingStudent;

    }


}
