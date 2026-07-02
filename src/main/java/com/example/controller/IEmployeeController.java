package com.example.controller;

import java.util.List;

import com.example.dto.DtoEmployee;
import com.example.entities.RootEntity;

public interface IEmployeeController {
	public RootEntity<List<DtoEmployee>> findAllEmployees();
	public RootEntity<DtoEmployee> findEmployeeById(Long id);
}
