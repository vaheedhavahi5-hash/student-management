package com.vaheedhatech.student_management.controller;

import com.vaheedhatech.student_management.dto.StudentDto;
import com.vaheedhatech.student_management.service.LibraryClientService;
import com.vaheedhatech.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private LibraryClientService libraryClientService;

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService; 
    }


    @PostMapping
    public String addDetails(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }
    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
    @PutMapping("/{id}")
    public StudentDto updateStudent(
            @PathVariable Long id,
            @RequestBody StudentDto studentDto){
        return studentService.updateStudent(id,studentDto);
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        String result=libraryClientService.checkUnreturnedBooks(id);
        if(result!=null&&!result.equals("[]")){
            return "DUE:please return the book before leaving school.";
        }
        String deleteResult=studentService.deleteStudent(id);
        return "NO DUE"+deleteResult;

    }

    @GetMapping("/{studentId}/check-books")
    public String checkStudentBooks(@PathVariable Long studentId){
        return libraryClientService.checkUnreturnedBooks(studentId);
    }

}