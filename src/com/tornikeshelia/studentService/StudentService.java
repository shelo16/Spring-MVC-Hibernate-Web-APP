package com.tornikeshelia.studentService;

import java.util.List;

import com.tornikeshelia.entity.Student;

public interface StudentService {
	
	// Again simple CRUD operations, we need to create Service Interface/Class so we don't access data through DAO.
	
	public List<Student> getStudents();
	
	public void saveStudent(Student student);
	
	public Student getStudent(int id);
	
	public void deleteStudent(int id);

}
