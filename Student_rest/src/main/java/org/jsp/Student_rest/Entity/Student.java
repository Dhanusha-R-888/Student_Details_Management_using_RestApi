package org.jsp.Student_rest.Entity;

import org.jsp.Student_rest.StudentDTO.StudentDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Student {

@Id
@GeneratedValue(generator ="id")
@SequenceGenerator(initialValue=101001, allocationSize=1,name="id")
    private Long id;
	private String name;
	//@Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
	//@Size(min=10,max=10,message="Phone number must be exactly 10 digits")
	@Min(value=1000000000L,message="Phone number must be exactly 10 digits")
	@Max(value=9999999999L,message="Phone number must be exactly 10 digits")
	private Long mobile;
	private Integer maths;
	private Integer science;
	private Integer english;
	private Double percentage;
	
	public Student(StudentDTO dto) {
		this.name=dto.getName();
		this.mobile=dto.getMobile();
		this.english=dto.getEnglish();
		this.maths=dto.getMaths();
		this.science=dto.getScience();
		this.percentage=(dto.getMaths()+dto.getScience()+dto.getEnglish())/3.0;
	}

}
