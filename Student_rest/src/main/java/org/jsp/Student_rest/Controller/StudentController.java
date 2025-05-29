package org.jsp.Student_rest.Controller;

import java.util.List;

import org.jsp.Student_rest.Entity.Student;
import org.jsp.Student_rest.Service.StudentService;
import org.jsp.Student_rest.StudentDTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	StudentService service;

	// Save a Record

	@PostMapping("/student")
	@Operation(summary = "Save a Record")
	public ResponseEntity<Student> saveStudent(@RequestBody  @Valid  StudentDTO dto) {
		// return "Its working "+dto;

		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(dto));
	}

	// Fetch Records

	@GetMapping("/students")
	@Operation(summary = "Fetch All Records")
	public ResponseEntity<List<Student>> fetchStudents(@RequestParam(defaultValue = "id") String sort,
			@RequestParam(defaultValue = "false") boolean desc, 
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "100") int data) {
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchAll(sort, desc, page, data));
	}

	// Save Multiple REcords

	@PostMapping("/students")
	@Operation(summary = "Save Multiple Records")
	public ResponseEntity<List<Student>> saveMultipleStudent(@RequestBody List<StudentDTO> dtos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudents(dtos));
	}
	
	//updating a Record
	
	@PutMapping("/student")
	@Operation(summary = "update Record")
	
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateStudent(student));
	}
		
    //Deleting a Record
		@DeleteMapping("/student/{id}")
		@Operation(summary = "Delete By ID")
		public ResponseEntity<String> deleteRecord(@PathVariable Long id){
			return ResponseEntity.status(HttpStatus.OK).body(service.deleteRecordById(id));
		}
		


}

