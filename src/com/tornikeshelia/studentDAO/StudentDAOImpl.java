package com.tornikeshelia.studentDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tornikeshelia.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	//Autowire sessionFactory so we can get currentSession!
	@Autowired
	private SessionFactory sessionFactory;
	
	// 1. Implement methods
	// 2. Get Current Session
	// 3. Wright the logic

	@Override
	public List<Student> getStudents() {
		// get the current session
		Session session = sessionFactory.getCurrentSession();
		// create a query ... sort by last name
		Query<Student> myQuery = session.createQuery("FROM Student ORDER BY lastName", Student.class);
		// execute query and get the result list 
		List<Student> myStudents = myQuery.getResultList();
		// return the results
		return myStudents;
	}

	@Override
	public void saveStudent(Student student) {
		
		//get current session
		Session session = sessionFactory.getCurrentSession();
		
		// save the student to db
		session.saveOrUpdate(student);
	}

	@Override
	public Student getStudent(int id) {
		//get current session
		Session session = sessionFactory.getCurrentSession();
		//get the student
		Student student = session.get(Student.class, id);
		// return student
		return student;
	}

	@Override
	public void deleteStudent(int id) {
		//get current session
		Session session = sessionFactory.getCurrentSession();
		// get the student
		Student student = session.get(Student.class, id);
		//delete the student
		session.delete(student);
	}

}
