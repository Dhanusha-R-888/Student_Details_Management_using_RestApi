package org.jsp.Student_rest.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DataAlreadyExistsException extends RuntimeException{
	String message="Data Already Exists";

}
