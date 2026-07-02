package com.example.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DtoDepartment;
import com.example.dto.DtoEmployee;
import com.example.entities.Employee;
import com.example.exception.BaseException;
import com.example.exception.ErrorMessage;
import com.example.exception.MessageType;
import com.example.repository.EmployeeRepository;
import com.example.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<DtoEmployee> findAllEmployees() {
		List<DtoEmployee> dtoEmployees= new ArrayList<>();
		
		List<Employee> employees = employeeRepository.findAll();
		
		if(employees!=null && !employees.isEmpty() ) {
			for(Employee employee:employees) {
				
				DtoEmployee dtoEmployee= new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoEmployee);
				
				dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(),
						employee.getDepartment().getDepartmentName(),employee.getDepartment().getLocation()));

				dtoEmployees.add(dtoEmployee);
			}
		}
		
		return dtoEmployees;
	}

	@Override
	public DtoEmployee findEmployeeById(Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,id.toString()));
		}
		DtoEmployee dtoEmployee= new DtoEmployee();
		BeanUtils.copyProperties(optional.get(), dtoEmployee);
		dtoEmployee.setDepartment(new DtoDepartment(optional.get().getDepartment().getId(),
				optional.get().getDepartment().getDepartmentName(),optional.get().getDepartment().getLocation()));
		return dtoEmployee;
	}

}
