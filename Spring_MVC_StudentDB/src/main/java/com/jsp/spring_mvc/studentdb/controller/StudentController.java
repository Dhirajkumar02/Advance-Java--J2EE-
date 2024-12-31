package com.jsp.spring_mvc.studentdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc.studentdb.entity.Student;
import com.jsp.spring_mvc.studentdb.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/add-student" , method = RequestMethod.POST)
	public ModelAndView addStudent(Student student) {

		return studentService.addStudent(student) ;
	}

	@RequestMapping(value = "/display-all-students" , method = RequestMethod.GET)
	public ModelAndView displayAllStudents() {
		return studentService.displayAllStudents();

	}
	@RequestMapping(value = "/find-by-id" , method = RequestMethod.GET)
	public ModelAndView findStudentById(@RequestParam int studentId) {
		return studentService.findStudentById(studentId);
	}

	@RequestMapping(value = "/save-updated-student" , method = RequestMethod.POST)	
	public ModelAndView updateStudent(Student student) {

		return studentService.updateStudetn(student);
	}

	@RequestMapping(value = "/delete-student" , method = RequestMethod.GET)
	public ModelAndView deleteStudent(@RequestParam int studentId) {
		return studentService.deleteStudent(studentId);
	}
}
