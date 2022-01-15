package com.rudesfot.springsecurity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rudesfot.springsecurity.entities.Student;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private static final List<Student> STUDENTS = 
			Arrays.asList(
					new Student(1,"Alex"),
					new Student(2,"Juanito"));

	//Seguir las nomenclaturas
	@GetMapping(path = "{studentId}")
	public Student obtenerPorId(@PathVariable("studentId") Integer studentId) {
		return STUDENTS.stream().filter
				(e->studentId.equals(e.getId()))
				.findFirst()
				.orElseThrow(()->new IllegalStateException("No se encontraron estudiantes con ese id"));
	}
}
