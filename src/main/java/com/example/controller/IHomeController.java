package com.example.controller;

import com.example.dto.DtoHome;
import com.example.entities.RootEntity;

public interface IHomeController {
	RootEntity<DtoHome> findHomeById(Long id);
}
