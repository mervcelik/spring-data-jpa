package com.example.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DtoAddress;
import com.example.dto.DtoCustomer;
import com.example.entities.Address;
import com.example.repository.AddressRepository;
import com.example.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public DtoAddress findAddressById(Long id) {
		Optional<Address> optional= addressRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		
		Address address=optional.get();
		DtoAddress dtoAddress= new DtoAddress();
		BeanUtils.copyProperties(address, dtoAddress);
		
		DtoCustomer dtoCustomer= new DtoCustomer();
		dtoCustomer.setId(address.getCustomer().getId());
		dtoCustomer.setName(address.getCustomer().getName());
		
		dtoAddress.setDtoCustomer(dtoCustomer);
		return dtoAddress;
	}

}
