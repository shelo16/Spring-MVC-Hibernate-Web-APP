package com.tornikeshelia.studentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tornikeshelia.entity.Student;
import com.tornikeshelia.studentDAO.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {
	
	//Autowire DAO so we can access its methods
	@Autowired
	private StudentDAO studentDAO;

	// 1. add @Transactional so we don't have to manually startTransaction and Commit transaction.
	// 2. use studentDAO on methods.
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		
		studentDAO.saveStudent(student);

	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		return studentDAO.getStudent(id);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);

	}

}
