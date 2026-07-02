package com.example.controller;

import com.example.dto.DtoAddress;
import com.example.entities.RootEntity;

public interface IAddressController {
	public RootEntity<DtoAddress> findAddressById(Long id);
}
