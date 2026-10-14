package com.vaheedhatech.student_management.service;

import com.vaheedhatech.student_management.dto.StudentDto;

import java.util.List;

public interface StudentService {
    String addStudent(StudentDto studentDto);

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto updateStudent(Long id, StudentDto studentDto);

    String deleteStudent(Long id);

}
