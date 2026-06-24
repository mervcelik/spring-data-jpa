package com.example.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
	@NotEmpty(message = "İsim boş bırakılamaz!")
	@Min(value = 3, message = "İsim 3 karakterden az olamaz")
	@Max(value = 10,message = "İsim 10 karakterden çok olamaz")
	private String firstName;
	
	@Size(max = 10,min = 3,message = "Soyad en az 3 karakter en fazla 10 karakter olmalıdır.")
	private String lastName;
	private String birthOfDate;
}
