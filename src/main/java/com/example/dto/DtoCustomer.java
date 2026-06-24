package com.example.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@JsonInclude(value = Include.NON_NULL) // eğer herhang bir değer null ise dişarıya dönme
public class DtoCustomer {
	private Long id;
	private String name;
	private DtoAddress address;
}
