package com.student.student_data.repository;

import com.student.student_data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByName(String name);
}
