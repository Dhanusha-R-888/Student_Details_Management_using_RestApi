package org.jsp.Student_rest.StudentDTO;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {
	private String name;
	//@Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
	private Long mobile;
	private Integer maths;
	private Integer science;
	private Integer english;
	

}
