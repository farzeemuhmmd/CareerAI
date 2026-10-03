package com.careerai.controller;

import com.careerai.model.Student;
import com.careerai.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Register a new student
    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(
            @RequestBody Student student) {

        Student savedStudent =
                studentRepository.save(student);

        return ResponseEntity.ok(savedStudent);
    }

    // Get all students
    @GetMapping
    public ResponseEntity<?> getAllStudents() {

        return ResponseEntity.ok(
                studentRepository.findAll()
        );
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(
            @PathVariable Long id) {

        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(
                        ResponseEntity.notFound().build()
                );
    }

    // Student login
    @PostMapping("/login")
    public ResponseEntity<?> loginStudent(
            @RequestBody Student loginRequest) {

        Student matchedStudent = studentRepository
                .findAll()
                .stream()
                .filter(student ->
                        student.getEmail()
                                .equalsIgnoreCase(
                                        loginRequest.getEmail()
                                )
                                &&
                        student.getPassword()
                                .equals(
                                        loginRequest.getPassword()
                                )
                )
                .findFirst()
                .orElse(null);

        if (matchedStudent == null) {

            return ResponseEntity
                    .status(401)
                    .body("Invalid email or password");
        }

        return ResponseEntity.ok(matchedStudent);
    }
}
