package com.careerai.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String course;

    private Double academicPercentage;

    public Student() {
    }

    public Student(String name, String email, String password,
                   String course, Double academicPercentage) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.course = course;
        this.academicPercentage = academicPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getAcademicPercentage() {
        return academicPercentage;
    }

    public void setAcademicPercentage(Double academicPercentage) {
        this.academicPercentage = academicPercentage;
    }
}
