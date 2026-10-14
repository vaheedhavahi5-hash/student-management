package com.vaheedhatech.student_management.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Integer age;
    private String course;
    private String admissionNo;
    private Instant admissionDate;

}
