package ae.etisalat.ems.service;

import org.springframework.stereotype.Service;
import ae.etisalat.ems.data.domain.Employee;
import ae.etisalat.ems.exception.EmployeeManagementException;

import java.util.List;


@Service
public interface IEmployeeService {
	
	
	public void addEmployee(Employee employee) throws EmployeeManagementException;
	
	public Employee getEmployeeDetail(int empId ) throws EmployeeManagementException;
	
	public List<Employee> getAllEmployees()throws EmployeeManagementException;
	
	public void updateEmployee (Employee book)throws EmployeeManagementException;
	
	public void deleteEmployee (int empId)throws EmployeeManagementException;
	
	public void deleteAllEmployee()throws EmployeeManagementException;
	
	
}