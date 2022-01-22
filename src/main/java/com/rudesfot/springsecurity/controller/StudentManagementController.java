package com.rudesfot.springsecurity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rudesfot.springsecurity.entities.Student;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

	private static final List<Student> STUDENTS = 
			Arrays.asList(
					new Student(1,"Alex"),
					new Student(2,"Juanito"));
	
	@GetMapping
	@PreAuthorize(value = "hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
	public List<Student> getAllStudents(){
		return STUDENTS;
	}
	
	
	@PostMapping
	@PreAuthorize(value = "hasAuthority('student:write')")
	public void createStudent(@RequestBody Student student){
		System.out.println(student);
	}
	
	@DeleteMapping(path = "{studentId}")
	@PreAuthorize(value = "hasAuthority('student:write')")
	public void deleteStudent(@PathVariable Integer studentId) {
		System.out.println(studentId);
	}
	
	@PutMapping(path = "{studentId}")
	@PreAuthorize(value = "hasAuthority('student:write')")
	public void updateStudent(@PathVariable Integer studentId,@RequestBody Student student) {
		System.out.println(String.format("%s %s",student,student));
	}
}
