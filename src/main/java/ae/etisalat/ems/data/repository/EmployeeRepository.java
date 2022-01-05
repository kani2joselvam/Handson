package ae.etisalat.ems.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ae.etisalat.ems.data.domain.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{


	//Page<Employee> findByTitleContaining(String title, Pageable pageable);
  
	//List<Employee> findByTitleContaining(String title, Sort sort);
	
	
}
