package com.example.controller;

import com.example.dto.DtoHome;

public interface IHomeController {
	DtoHome findHomeById(Long id);
}
