package com.codemyth.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemyth.model.Student;
import com.codemyth.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/student")
	public String createNewStudent(@RequestBody Student student)
	{
		
		studentRepository.save(student);
		return "Student created in database Successfully..";
	}
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> studList=new ArrayList();
		studentRepository.findAll().forEach(studList::add);
		return new ResponseEntity<List<Student>>(studList,HttpStatus.OK);
		
	}
	@GetMapping("/student/{studid}")
	public ResponseEntity<Student> getEmployeeById(@PathVariable long studid)
	{
		Optional<Student> stud=studentRepository.findById(studid);
		if(stud.isPresent())
		{
			return new ResponseEntity<Student>(stud.get(),HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);

		}
	}
	// update
	@PutMapping("/student/{studid}")
	public String updateStudentById(@PathVariable long studid,@RequestBody Student students )
	{
		Optional<Student> stud=studentRepository.findById(studid);
		if(stud.isPresent())
		{
			Student existstu=stud.get();
			existstu.setStud_age(students.getStud_age());
			existstu.setStud_name(students.getStud_name());
			existstu.setStud_city(students.getStud_city());
			existstu.setStud_email(students.getStud_email());
			studentRepository.save(existstu);
			return "Student Details against Id" +studid+"updated.";
			
		}else {
			return "Student Details doen not exist for student Id" +studid;

		}

	}
	
	// delete one record
	
	@DeleteMapping("/student/{studid}")
	public String deleteStudentById(@PathVariable long studid)
	{
		studentRepository.deleteById(studid);
		return "Student data deleted Successfully";
	}
	
	// delete all record
	
	@DeleteMapping("/student")
	public String deleteStudent()
	{
		studentRepository.deleteAll();
		return "Student data deleted Successfully";

	}
	
	
	
	

}
