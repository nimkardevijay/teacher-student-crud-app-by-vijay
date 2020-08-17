package com.studentteacher.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studentteacher.entity.Student;
import com.studentteacher.entity.Teacher;
import com.studentteacher.repository.TeacherRepository;

@Controller
@RequestMapping("/teachers/")
public class TeacherController {

	private final TeacherRepository teacherRepository;

	@Autowired
	public TeacherController(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Teacher teacher) {
		return "add-teacher";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		List<Teacher> tlist = teacherRepository.findAll();
		
		model.addAttribute("teachers", teacherRepository.findAll());
		return "teachers-list";
	}

	@PostMapping("add")
	public String addTeacher(@Valid Teacher teacher, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-teacher";
		}		
		teacherRepository.saveAndFlush(teacher);

		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Teacher teacher = teacherRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + id));
		model.addAttribute("teacher", teacher);
		return "update-student";
	}

	@PostMapping("update/{id}")
	public String updateTeacher(@PathVariable("id") long id, @Valid Teacher teacher, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			teacher.setTid(id);
			return "update-student";
		}

		teacherRepository.save(teacher);
		model.addAttribute("teachers", teacherRepository.findAll());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteTeacher(@PathVariable("id") long id, Model model) {
		Teacher teacher = teacherRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + id));
		teacherRepository.delete(teacher);
		model.addAttribute("teachers", teacherRepository.findAll());
		return "index";
	}

	// @GetMapping("teacher2/{teacherName}")
	// List <Student> getAllStudentByTeacherName(@PathVariable("teacherName") String
	// teacherName){
	//
	// List <Student> list= teacherRepository.findByTName(teacherName);
	// System.out.println("--------------------->"+list);
	// return list;
	// }
}
