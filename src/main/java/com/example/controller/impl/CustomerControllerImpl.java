package com.example.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.ICustomerController;
import com.example.dto.DtoCustomer;
import com.example.entities.RootEntity;
import com.example.services.ICustomerService;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl extends RestBaseController implements ICustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping(path = "list/{id}")
	@Override
	public RootEntity<DtoCustomer> findCustomerById(@PathVariable Long id) {
		DtoCustomer dtoCustomer = customerService.findCustomerById(id);
		return ok(dtoCustomer);
	}

}
