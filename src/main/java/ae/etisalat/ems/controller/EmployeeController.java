package ae.etisalat.ems.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ae.etisalat.ems.common.dto.EmployeeDTO;
import ae.etisalat.ems.data.domain.Employee;
import ae.etisalat.ems.exception.EmployeeManagementException;
import ae.etisalat.ems.mapper.MapStructMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import javax.validation.Valid;

import ae.etisalat.ems.service.IEmployeeService;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	
    @Autowired
    private IEmployeeService employeeService;
    
    @Autowired
    private MapStructMapper mapstructMapper;
	
	@PostMapping ("/")
	public ResponseEntity<Void> addBook(@RequestBody @Valid EmployeeDTO empDTO) throws Exception {
		
			this.employeeService.addEmployee(mapstructMapper.empDTOToEmployee(empDTO));
			logger.info("insde add book"+empDTO.toString());
			return new ResponseEntity<>(HttpStatus.CREATED);
			
		
    }
	
	
	@GetMapping ("/{id}")
	public ResponseEntity<EmployeeDTO> getBook(@PathVariable("id")int empId) throws EmployeeManagementException {
		Employee book = this.employeeService.getEmployeeDetail(empId);
			if(book!=null){
				EmployeeDTO bookDTO = mapstructMapper.empToEmpDTO(book);
				return new ResponseEntity<EmployeeDTO>(bookDTO,HttpStatus.OK);
			}else{
				throw new EmployeeManagementException("NO_RECORDS_FOUND","No record found for this search critera");
			}
	        
	    }
	
	@GetMapping ("/")
	public ResponseEntity<List<EmployeeDTO>>  getAllEmployee() throws Exception {
	        return new ResponseEntity<List<EmployeeDTO>>(mapstructMapper.toEmpDTOs(this.employeeService.getAllEmployees()),HttpStatus.OK);
	    }

	@PutMapping ("/")
	public ResponseEntity<Void> updateEmployee(@RequestBody EmployeeDTO empDTO) throws Exception {
		this.employeeService.updateEmployee(mapstructMapper.empDTOToEmployee(empDTO));
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	    }
	
	@DeleteMapping ("/")
	public ResponseEntity<Void> deleteAllEmployee() throws Exception {
		this.employeeService.deleteAllEmployee();
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int empId) throws Exception {
		this.employeeService.deleteEmployee(empId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}


