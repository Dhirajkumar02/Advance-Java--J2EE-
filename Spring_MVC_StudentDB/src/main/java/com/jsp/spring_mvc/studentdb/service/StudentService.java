package com.jsp.spring_mvc.studentdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import com.jsp.spring_mvc.studentdb.entity.Student;
import com.jsp.spring_mvc.studentdb.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public ModelAndView addStudent(Student student) {
		studentRepository.addStudent(student);

		//		ModelAndView mav = new ModelAndView();
		//		mav.setViewName("index.jsp");
		//		return mav

		// reducing the number of lines code
		return new ModelAndView("index.jsp");

	}

	public ModelAndView displayAllStudents() {
		//Fetching all the students Details from the DB table
		List<Student> students = studentRepository.displayAllStudents();

		//		ModelAndView mav = new ModelAndView();
		//		mav.setViewName("DisplayAllStudents.jsp");
		//		mav.addObject("studentList", students);
		//		return mav;

		return new ModelAndView("DisplayAllStudents.jsp").addObject("studentList", students);

	}

	public ModelAndView findStudentById(int studentId) {
		/// Fetching the student Object based on id
		Student student = studentRepository.findStudentById(studentId);

		//		ModelAndView mav = new ModelAndView();
		//		mav.setViewName("UpdateStudent.jsp");
		//		mav.addObject("studentObject", student);
		//		return mav;

		return new ModelAndView("UpdateStudent.jsp").addObject("studentObject", student);
	}

	public ModelAndView updateStudetn(Student student) {
		// Update the student record in the database
		studentRepository.updateStudent(student);

		// 1st way
		//		List<Student> students = studentRepository.displayAllStudents();
		//
		//		ModelAndView mav = new ModelAndView();
		//		mav.setViewName("DisplayAllStudents.jsp");
		//		mav.addObject("studentList", students);
		//		return mav;	

		// 2nd way
		//		ModelAndView mav = new ModelAndView();
		//		mav.setViewName("redirect:display-all-students");
		//		return mav;	

		return new ModelAndView("redirect:display-all-students");
	}

	public ModelAndView deleteStudent(int studentId) {
		// Deleting the student record from the database
		studentRepository.deleteStudentById(studentId);

		//			ModelAndView mav = new ModelAndView();
		//			mav.setViewName("redirect:display-all-students");
		//			return mav;

		return new ModelAndView("redirect:display-all-students");

	}
}
