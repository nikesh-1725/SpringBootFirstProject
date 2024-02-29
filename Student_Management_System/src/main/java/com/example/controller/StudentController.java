package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Student;
import com.example.service.StudentService;

@Controller
public class StudentController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(StudentController.class);
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle list of Students amd return mode and view
	@GetMapping("/students")
	public String listStudents(Model model)
	{
		LOGGER.info("List of Students method is starting");
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
	}
	

	@GetMapping("/students/new")
	public String createStudentForm(Model model)
	{
		//create student object to hold student from data
		LOGGER.info("Creating the student forms method is started");
		Student student=new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		//LOGGER.info("The values of ");
		
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")	
	public String editStudentForm(@PathVariable Long id, Model model)
	{
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	// Save Updated Student Object
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		
		// Get Student from database by using id
	
		Student exisitingStuent = studentService.getStudentById(id);
		exisitingStuent.setId(id);
		exisitingStuent.setFirstName(student.getFirstName());
		exisitingStuent.setLastName(student.getLastName());
		exisitingStuent.setEmail(student.getEmail());
		
		
		// save updated student object
		studentService.updateStudent(exisitingStuent);
		
		return "redirect:/students";
	}
	
	// Handler method to handle Delete Student Request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	

	
	


}
