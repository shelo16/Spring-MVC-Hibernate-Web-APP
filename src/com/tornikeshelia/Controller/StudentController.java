package com.tornikeshelia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tornikeshelia.entity.Student;
import com.tornikeshelia.studentService.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/list")
	public String studentList(Model model) {
		//get students list from DB
		List<Student> myStudents = studentService.getStudents();
		
		//add students to model
		model.addAttribute("myStudentList",myStudents);
		
		return "student-list";
	}
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		//Create empty student object and add it to model for form.
		Student student = new Student();
		
		model.addAttribute("myStudent",student);
		
		return "student-form";
	}
	
	@PostMapping("/showPostForm")
	public String showPostForm(@ModelAttribute("myStudent")Student student) {
		//save the student 
		studentService.saveStudent(student);
		//redirect to list page
		return "redirect:/student/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
		//pre-populate student so we can edit it.
		Student student = studentService.getStudent(id);
		//add that pre-populated student to the model
		model.addAttribute("myStudent",student);
		// return form (the form should be filled with the pre-populated data)
		return "student-form";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId")int id) {
		//delete the student with id
		studentService.deleteStudent(id);
		return "redirect:/student/list";
	}
	
	
	
}
