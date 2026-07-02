package com.example.controller;

import com.example.dto.DtoCustomer;
import com.example.entities.RootEntity;

public interface ICustomerController {

	public RootEntity<DtoCustomer> findCustomerById(Long id);
}
