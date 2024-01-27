package net.javaguides.sms.controller;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.entity.StudentsClass;
import net.javaguides.sms.service.ClassService;
import net.javaguides.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class StudentController {

	private StudentService studentService;

	private ClassService classService;
	@Autowired
	public StudentController(StudentService studentService, ClassService classService) {
		this.studentService = studentService;
		this.classService = classService;
	}

	// handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {

		model.addAttribute("students", studentService.getAllStudents());
		return "students"; // The name of Thymeleaf HTML template
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("allClasses", classService.getAllClasses());
		return "create_student";

	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		Set<StudentsClass> selectedClasses = student.getClasses();
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}




}
