package org.jsp.Student_rest.StudentDTO;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class StudentDTO {
	private String name;

	private Long mobile;
	private Integer maths;
	private Integer science;
	private Integer english;
	

}
