package com.example.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IStudentController;
import com.example.dto.DtoStudent;
import com.example.dto.DtoStudentIU;
import com.example.entities.RootEntity;
import com.example.services.IStudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl extends RestBaseController implements IStudentController {

	
	@Autowired
	private IStudentService studentService;
	
	@PostMapping(path = "/save")
	@Override
	public RootEntity<DtoStudent> saveStudent(@RequestBody @Valid DtoStudentIU student) {
		DtoStudent dtoStudent = studentService.saveStudent(student);
		return ok(dtoStudent);
	}

	@GetMapping(path = "/list")
	@Override
	public RootEntity<List<DtoStudent>> getAllStudents() {
		List<DtoStudent> list = studentService.getAllStudents();
		return ok(list);
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public RootEntity<DtoStudent> getStudentById(@PathVariable Integer id) {
		DtoStudent dtoStudent = studentService.getStudentById(id);
		return ok(dtoStudent);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public RootEntity<DtoStudent> updateStudent(@PathVariable Integer id,@RequestBody @Valid DtoStudentIU updateStudent) {
		DtoStudent dtoStudent = studentService.updateStudent(id, updateStudent);
		return ok(dtoStudent);
	}

	
}
