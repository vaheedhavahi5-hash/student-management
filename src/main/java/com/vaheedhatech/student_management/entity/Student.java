package com.vaheedhatech.student_management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "STUDENTS")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "COURSE")
    private String course;

    @Column(name = "AGE")
    private int age;

    @Column(name = "ADMISSION_NO")
    private String admissionNo;

    @Column(name = "ADMISSION_DATE")
    private Instant admissionDate;


}
