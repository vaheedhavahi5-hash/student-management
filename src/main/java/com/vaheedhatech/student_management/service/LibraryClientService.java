package com.vaheedhatech.student_management.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
@Service
public class LibraryClientService {
    @Autowired
    private RestTemplate restTemplate;

    public String checkUnreturnedBooks(Long studentId){
        String url="http://localhost:8082/book-issue/student/"+studentId+"/unreturned";

        String response=restTemplate.getForObject(url,String.class);

        return response;
    }
}
