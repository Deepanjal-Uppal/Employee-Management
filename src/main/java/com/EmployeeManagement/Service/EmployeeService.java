package com.EmployeeManagement.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.EmployeeManagement.DTO.EmployeeDTO;
import com.EmployeeManagement.Exceptions.ResourceNotFoundException;

public interface EmployeeService {
	EmployeeDTO create(EmployeeDTO dto);
	EmployeeDTO getById(Long id) throws ResourceNotFoundException;
//	Page<EmployeeDTO> list(Pageable pageable); //sorting n pagination // like if we want 5 records only on one pg
	EmployeeDTO updatePut(Long id, EmployeeDTO dto) throws ResourceNotFoundException ; //we will do full overwrite
	EmployeeDTO updatePatch(Long id, EmployeeDTO dto) throws ResourceNotFoundException ; //partial and ignore nulls
	void delete(Long id) throws ResourceNotFoundException;
}
