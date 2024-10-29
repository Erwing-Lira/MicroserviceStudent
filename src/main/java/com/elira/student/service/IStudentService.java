package com.elira.student.service;

import com.elira.student.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Student saveStudent(Student student);

    List<Student> findAll();

    Optional<Student> findById(Long id);

    List<Student> findByIdCourse(Long idCourse);
}
