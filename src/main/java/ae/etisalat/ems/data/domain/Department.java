package ae.etisalat.ems.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="departments")
public class Department {	
	
	@Id
	@Column(name = "department_id")
	private long departmentId;
	  
	@Column(name = "department_name")
	private String departmentName; 
	
	@Column(name = "manager_id")
	private long managerId;
		
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public long getManagerId() {
		return managerId;
	}
	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	
	
	
	public Department(long departmentId, String departmentName,long managerId) {
		this.managerId=managerId;
		this.departmentId=departmentId;
		this.departmentName=departmentName;
	}
	public Department(){
		super();
	}
	
}
