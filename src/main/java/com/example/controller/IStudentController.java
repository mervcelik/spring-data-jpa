package com.example.controller;

import java.util.List;

import com.example.dto.DtoStudent;
import com.example.dto.DtoStudentIU;
import com.example.entities.RootEntity;

public interface IStudentController {

	public RootEntity<DtoStudent> saveStudent(DtoStudentIU student);
	public  RootEntity<List<DtoStudent>> getAllStudents();
	public RootEntity<DtoStudent> getStudentById(Integer id);
	public void deleteStudent(Integer id);
	public RootEntity<DtoStudent> updateStudent(Integer id,DtoStudentIU updateStudent);
}
