package com.example.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DtoDepartment;
import com.example.dto.DtoEmployee;
import com.example.entities.Employee;
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
						employee.getDepartment().getDepartmentName()));

				dtoEmployees.add(dtoEmployee);
			}
		}
		
		return dtoEmployees;
	}

}
