package com.vaheedhatech.student_management.service.impl;

import com.vaheedhatech.student_management.dto.StudentDto;
import com.vaheedhatech.student_management.entity.Student;
import com.vaheedhatech.student_management.repository.StudentRepository;
import com.vaheedhatech.student_management.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }


    @Override
    public String addStudent(StudentDto studentDto){

        Student student=new Student();

        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());
        student.setAdmissionNo(studentDto.getAdmissionNo());
        student.setCourse(studentDto.getCourse());
        student.setPhone(studentDto.getPhone());
        student.setAdmissionDate(studentDto.getAdmissionDate());


        studentRepository.save(student);
        return "Student Created Successfully";
    }

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students= studentRepository.findAll();

        List<StudentDto>studentDtos=new ArrayList<>();

        for(Student student:students) {

            StudentDto dto = new StudentDto();

            dto.setId(student.getId());
            dto.setName(student.getName());
            dto.setEmail(student.getEmail());
            dto.setAge(student.getAge());
            dto.setAdmissionNo(student.getAdmissionNo());
            dto.setCourse(student.getCourse());
            dto.setPhone(student.getPhone());
            dto.setAdmissionDate(student.getAdmissionDate());

            studentDtos.add(dto);
        }


        return studentDtos;
    }

    @Override
    public StudentDto getStudentById(Long id) {

        Student student=studentRepository.findById(id).orElseThrow(()->
        new RuntimeException("Student not found with id:"+id));

        StudentDto dto=new StudentDto();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());
        dto.setAdmissionNo(student.getAdmissionNo());
        dto.setCourse(student.getCourse());
        dto.setPhone(student.getPhone());
        dto.setAdmissionDate(student.getAdmissionDate());

        return dto;
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {

        Student student=studentRepository.findById(id).orElseThrow(()->
                new RuntimeException("Students not found with id:"+id));
        student.setName(studentDto.getName());
        student.setCourse(studentDto.getCourse());
        student.setAdmissionDate(studentDto.getAdmissionDate());
        student.setPhone(studentDto.getPhone());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());
        student.setAdmissionNo(studentDto.getAdmissionNo());

        Student updatedStudent=studentRepository.save(student);

        StudentDto response=new StudentDto();

        response.setId(updatedStudent.getId());
        response.setName(updatedStudent.getName());
        response.setCourse(updatedStudent.getCourse());
        response.setAdmissionDate(updatedStudent.getAdmissionDate());
        response.setPhone(updatedStudent.getPhone());
        response.setEmail(updatedStudent.getEmail());
        response.setAge(updatedStudent.getAge());
        response.setAdmissionNo(updatedStudent.getAdmissionNo());

        return response;
    }

    @Override
    public String deleteStudent(Long id) {
        Student student=studentRepository.findById(id).orElseThrow(()->
                new RuntimeException("Student not found with id:"+id));
studentRepository.delete(student);

        return "";
    }
}

