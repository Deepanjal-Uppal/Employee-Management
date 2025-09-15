package com.EmployeeManagement.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.EmployeeManagement.DTO.EmployeeDTO;
import com.EmployeeManagement.Entity.Employee;

@Component
public class EmployeeManualMapper {

	public static Employee toEntity(EmployeeDTO dto) {
		if (dto == null)
			return null;

		Employee employee = new Employee();
		employee.setId(dto.getId());
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmail(dto.getEmail());
		employee.setPhoneNumber(dto.getPhoneNumber());
		employee.setAge(dto.getAge());
		employee.setDateOfJoining(dto.getDateOfJoining());
		employee.setDepartment(dto.getDepartment() == null ? null : Employee.Department.valueOf(dto.getDepartment()));

		return employee;
	}

	public static EmployeeDTO toDto(Employee employee) {

		if (employee == null)
			return null;

		EmployeeDTO employeeDto = new EmployeeDTO();
		employeeDto.setId(employee.getId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setEmail(employee.getEmail());
		employeeDto.setPhoneNumber(employee.getPhoneNumber());
		employeeDto.setDateOfJoining(employee.getDateOfJoining());
		employeeDto.setAge(employee.getAge());
		employeeDto.setDepartment(
				employee.getDepartment() == null ? null : employee.getDepartment().name());

		return employeeDto;

	}

	public static List<EmployeeDTO> toDtoList(List<Employee> list) {

		return list == null ? List.of() : list.stream().map(EmployeeManualMapper::toDto).collect(Collectors.toList());

	}
	//put so that id remains unchanged
	//Put style overwrite(dont change id or keep id unchanged
	public static void overwrite(Employee target, EmployeeDTO dto) {
		
		if (target == null || dto == null)
			return ;

		if(dto.getId() != 0)target.setId(dto.getId());
		
		target.setFirstName(dto.getFirstName());
		target.setLastName(dto.getLastName());
		target.setEmail(dto.getEmail());
		target.setPhoneNumber(dto.getPhoneNumber());
		target.setAge(dto.getAge());
		target.setDepartment(dto.getDepartment() == null ? null : Employee.Department.valueOf(dto.getDepartment()));

	}
	
	//Patch - style -- copy ONLY NON NULL FIELDS FOR INSERTION
	public static void patch(Employee target, EmployeeDTO dto) {
		if (target == null || dto == null) return;
		if (dto.getFirstName() != null) target.setFirstName(dto.getFirstName());
		if (dto.getLastName() != null) target.setFirstName(dto.getLastName());
		if (dto.getEmail() != null) target.setEmail(dto.getEmail());
		if (dto.getPhoneNumber() != null) target.setPhoneNumber(dto.getPhoneNumber());
		if (dto.getAge() != null) target.setAge(dto.getAge());
		if (dto.getDateOfJoining() != null) target.setDateOfJoining(dto.getDateOfJoining());
		if (dto.getDepartment() != null) target.setDepartment(dto.getDepartment() == null ? null : Employee.Department.valueOf(dto.getDepartment()));
	}
	
//	public Page<Employee> toDtoPage(Page<Employee> page){
//		return page.map(this::toDto);
//	}

}
