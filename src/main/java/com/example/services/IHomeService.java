package com.example.services;

import com.example.dto.DtoHome;

public interface IHomeService {

	DtoHome findHomeById(Long id);
}
