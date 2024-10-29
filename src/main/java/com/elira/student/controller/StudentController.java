package com.elira.student.controller;

import com.elira.student.entities.Student;
import com.elira.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveStudent(
            @RequestBody Student student
    ) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(
            @PathVariable Long id
    ) {
        Optional<Student> studentOptional = studentService.findById(id);

        if (studentOptional.isPresent()) {
            return ResponseEntity.ok(studentOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(
            @PathVariable Long idCourse
    ){
        return ResponseEntity.ok(studentService.findByIdCourse(idCourse));
    }
}
