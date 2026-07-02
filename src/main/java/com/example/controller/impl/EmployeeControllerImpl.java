package com.example.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IEmployeeController;
import com.example.dto.DtoEmployee;
import com.example.entities.RootEntity;
import com.example.services.IEmployeeService;

@RestController
@RequestMapping("rest/api/employee")
public class EmployeeControllerImpl extends RestBaseController implements IEmployeeController{

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/list")
	@Override
	public RootEntity<List<DtoEmployee>> findAllEmployees() {
		List<DtoEmployee> list = employeeService.findAllEmployees();
		return ok(list);
	}

	@GetMapping("/list/{id}")
	@Override
	public RootEntity<DtoEmployee> findEmployeeById(@PathVariable Long id) {
		DtoEmployee dtoEmployee = employeeService.findEmployeeById(id);
		return ok(dtoEmployee);
	}

	
}
