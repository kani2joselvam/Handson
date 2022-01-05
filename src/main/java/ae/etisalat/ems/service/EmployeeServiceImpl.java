package ae.etisalat.ems.service;

import org.springframework.stereotype.Service;
import ae.etisalat.ems.exception.EmployeeManagementException;
import ae.etisalat.ems.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import ae.etisalat.ems.common.constant.EmployeeManagementConstants;
import ae.etisalat.ems.data.domain.Employee;
import ae.etisalat.ems.data.repository.EmployeeRepository;


@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService  {
	
	@Autowired
	private EmployeeRepository empRepository;	


	@Override
	public void addEmployee(Employee book) {
		try{
			empRepository.save(book);	
		}catch(Exception e){
			e.printStackTrace();
			throw new EmployeeManagementException(EmployeeManagementConstants.INTERNAL_SERVER_ERROR_CODE, EmployeeManagementConstants.INTERNAL_SERVER_ERROR_MESSAGE);
		}
			
	}


	@Override
	public Employee getEmployeeDetail(int empId) {
		return empRepository.getById(empId);
	}


	@Override
	public void updateEmployee(Employee employee) {
		Optional<Employee> empObj = empRepository.findById(employee.getEmployeeId());
		
		if(empObj.isPresent()){
			empRepository.save(employee);		
		}
		
	}


	@Override
	public void deleteEmployee(int empId) {
		empRepository.deleteById(empId);
		
	}


	@Override
	public void deleteAllEmployee() {
		empRepository.deleteAll();
		
	}


	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList= new ArrayList<Employee>();
		empRepository.findAll().forEach(empList::add);
		return empList;
	}

	
}