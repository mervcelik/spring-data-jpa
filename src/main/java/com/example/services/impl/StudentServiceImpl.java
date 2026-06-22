package com.example.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DtoStudent;
import com.example.dto.DtoStudentIU;
import com.example.entities.Student;
import com.example.repository.StudentRepository;
import com.example.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudent) {
		DtoStudent response = new DtoStudent();
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudent, student);
		Student dbStudent = studentRepository.save(student);

		BeanUtils.copyProperties(student, response);
		return response;
	}

	@Override
	public List<DtoStudent> getAllStudents() {
		// TODO Auto-generated method stub
		List<DtoStudent> response = new ArrayList();
		List<Student> list = studentRepository.findAll();
		for (Student student : list) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			response.add(dtoStudent);
		}
		return response;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		// TODO Auto-generated method stub
		DtoStudent response = new DtoStudent();
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			BeanUtils.copyProperties(optional.get(), response);
			return response;
		}
		return null;
	}

	@Override
	public void deleteStudent(Integer id) {
//		// TODO Auto-generated method stub
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
		// TODO Auto-generated method stub
		DtoStudent dto = new DtoStudent();

		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			Student dbStudent = optional.get();

			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

			Student updatedStudent = studentRepository.save(dbStudent);

			BeanUtils.copyProperties(updatedStudent, dto);
			return dto;
		}

		return null;
	}

}
