package org.jsp.Student_rest.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataNotFoundException extends RuntimeException{
	
	String message="No Data present";

}
