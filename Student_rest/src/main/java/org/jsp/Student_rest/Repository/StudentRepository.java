package org.jsp.Student_rest.Repository;

import org.jsp.Student_rest.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student, Long>{

	boolean existsByMobile(Long mobile);

}
