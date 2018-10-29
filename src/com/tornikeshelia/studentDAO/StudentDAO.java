package com.tornikeshelia.studentDAO;

import java.util.List;

import com.tornikeshelia.entity.Student;

public interface StudentDAO {
	
	//add simple CRUD operations
	
	public List<Student> getStudents();
	
	public void saveStudent(Student student);
	
	public Student getStudent(int id);
	
	public void deleteStudent(int id);
	

}
