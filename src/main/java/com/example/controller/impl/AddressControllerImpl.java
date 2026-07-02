package com.example.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IAddressController;
import com.example.dto.DtoAddress;
import com.example.entities.RootEntity;
import com.example.services.IAddressService;


@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl extends RestBaseController implements IAddressController{

	
	@Autowired 
	private IAddressService addressService;
	
	@GetMapping(path = "/list/{id}")
	@Override
	public RootEntity<DtoAddress> findAddressById(@PathVariable Long id) {
		DtoAddress dto = addressService.findAddressById(id);
		return ok(dto);
	}

}
