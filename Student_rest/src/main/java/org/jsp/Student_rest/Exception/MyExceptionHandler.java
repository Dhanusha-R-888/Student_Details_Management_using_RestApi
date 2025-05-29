package org.jsp.Student_rest.Exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class MyExceptionHandler {
	
	
	@ExceptionHandler(DataAlreadyExistsException.class)
	public ResponseEntity<HashMap<String,String>> handle(DataAlreadyExistsException exception) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("message", exception.getMessage());
		return   ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		
	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<HashMap<String,String>> handle() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("message", "URL not mapped");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<HashMap<String,String>> handle(DataNotFoundException exception) {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

}
