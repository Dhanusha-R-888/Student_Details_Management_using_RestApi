package org.jsp.Student_rest.Service;

import java.util.ArrayList;
import java.util.List;

import org.jsp.Student_rest.Entity.Student;
import org.jsp.Student_rest.Exception.DataAlreadyExistsException;
import org.jsp.Student_rest.Exception.DataNotFoundException;
import org.jsp.Student_rest.Repository.StudentRepository;
import org.jsp.Student_rest.StudentDTO.StudentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public Student saveStudent(StudentDTO dto) {
		if (!repository.existsByMobile(dto.getMobile())) {
			Student student = new Student(dto);
			repository.save(student);
			return student;
		} else {
			throw new DataAlreadyExistsException("Mobile Number Already Exists: " + dto.getMobile());
		}
	}

	public List<Student> fetchAll(String sort, boolean desc, int page, int data) {
		
		Sort sortBasedon =Sort.by(sort);
		if(desc)
			sortBasedon = sortBasedon.descending();
		
		PageRequest pageable= PageRequest.of(page-1, data,sortBasedon);
		Page<Student> records=repository.findAll(pageable);
		
		if (!records.isEmpty()) {
			return records.getContent();
		} else {
			throw new DataNotFoundException();
		}

	}

	public List<Student> saveStudents(List<StudentDTO> dtos) {
		List<Student> students = new ArrayList<Student>();
		for (StudentDTO dto : dtos) {
			if (repository.existsByMobile(dto.getMobile())) {
				throw new DataAlreadyExistsException("Mobile Number Already Exists: " + dto.getMobile());
			} else {
				students.add(repository.save(new Student(dto)));
			}
		}

		return students;
	}

	public Student updateStudent(Student student) {
		return repository.save(student);
	}

	public String deleteRecordById(Long id) {
		repository.deleteById(id);
		return "Data  Removed Success";
	}


		
		

}
