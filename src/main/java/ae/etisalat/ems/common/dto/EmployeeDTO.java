package ae.etisalat.ems.common.dto;


import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDTO {	
	
	@JsonProperty("employeeId")
	private int employeeId;	 
	
	@JsonProperty("firstName")
	@NotEmpty(message = "First Name cannot be empty")
	@Size(min=2, max=30, message = "First Name must have minmum 2 characters")
	private String firstName;
	
	@JsonProperty("lastName")
	@NotEmpty(message = "Last Name cannot be empty")
	@Size(min=2, max=30, message = "Last Name must have minmum 2 characters")
	private String lastName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phoneNumber")
	@Pattern(regexp="^[0-9-]*$",message = "Phone number can have only number and digits")
	private String phoneNumber;
	
	@JsonProperty("hireDate")
	private Date hireDate;
	
	@JsonProperty("salary")
	@DecimalMin(value ="1.0" ,message = "Salary must be greater than 0") 
	private double salary;
	
	@JsonProperty("managerId")
	private int managerId;	 
	
	@JsonProperty("departmentId")
	private int departmentId;	 
	

	
		  
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public EmployeeDTO(Integer employeeId, String firstName, String lastName, String email, String phoneNumber, Date hireDate, double salary , Integer managerId, Integer departmentId) {
		this.employeeId=employeeId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.hireDate=hireDate;
		this.salary=salary;
		this.managerId=managerId;
		this.departmentId=departmentId;
	}
	public EmployeeDTO(){
		super();
	}
	
	
}
