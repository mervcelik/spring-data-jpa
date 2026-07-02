package com.example.services;

import java.util.List;

import com.example.dto.DtoEmployee;

public interface IEmployeeService {

	public List<DtoEmployee> findAllEmployees();
	
	public DtoEmployee findEmployeeById(Long id);
}
