package com.example.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.configuration.GlobalProperties;
import com.example.configuration.Server;

@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {

	@Autowired
	private GlobalProperties globalProperties;

	@GetMapping(value = "/getServers")
	public List<Server> getServers() {
		return globalProperties.getServers();

	}
}