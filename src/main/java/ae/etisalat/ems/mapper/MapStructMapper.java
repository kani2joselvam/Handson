package ae.etisalat.ems.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import ae.etisalat.ems.common.dto.EmployeeDTO;
import ae.etisalat.ems.data.domain.Employee;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
	
	@Mappings({
	      @Mapping(target="departmentId", source="emp.department.departmentId")
	    })
	EmployeeDTO empToEmpDTO(
			Employee emp
    );
	
	@Mappings({
	      @Mapping(target="department.departmentId", source="empDTO.departmentId")
	    })
	Employee empDTOToEmployee(
    		EmployeeDTO empDTO
    );
    
    List<EmployeeDTO> toEmpDTOs(List<Employee> emps);
}