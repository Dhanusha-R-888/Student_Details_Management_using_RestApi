package org.jsp.Student_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(contact = @Contact(email = "dhanusha8881@gmail.com",name = "Dhanusha R"),version = "1.0.0",title = "Student Rest Api",description = "we created a rest api using spring boot for performing crud operation"))
public class StudentRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRestApplication.class, args);
	}

}
