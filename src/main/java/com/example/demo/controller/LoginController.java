package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins="http://localhost:5173/")
public class LoginController {
	   @PostMapping()
	    public String login() {
	        // Perform login logic here
	        // For example, you could check if the email and password are valid
	        
	       
	         
	            return"Login successful";
	       
	    }
}
	    
