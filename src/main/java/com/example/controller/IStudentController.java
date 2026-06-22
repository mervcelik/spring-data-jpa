package com.example.controller;

import java.util.List;

import com.example.dto.DtoStudent;
import com.example.dto.DtoStudentIU;
import com.example.entities.Student;

public interface IStudentController {

	public DtoStudent saveStudent(DtoStudentIU student);
	public  List<DtoStudent> getAllStudents();
	public DtoStudent getStudentById(Integer id);
	public void deleteStudent(Integer id);
	public DtoStudent updateStudent(Integer id,DtoStudentIU updateStudent);
}
