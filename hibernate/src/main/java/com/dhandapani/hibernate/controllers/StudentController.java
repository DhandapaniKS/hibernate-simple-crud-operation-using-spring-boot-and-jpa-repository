package com.dhandapani.hibernate.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhandapani.hibernate.models.ApiResponse;
import com.dhandapani.hibernate.models.Student;
import com.dhandapani.hibernate.services.StudentService;

@RestController
@RequestMapping(value = "/studentrestapi")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ApiResponse> getStudents() {
		ApiResponse response = new ApiResponse();
		response.setException(false);
		try {
			List<Student> studentsAsList = new ArrayList<Student>();
			studentsAsList = studentService.getStudents();
			List<Object> objects = new ArrayList<Object>(studentsAsList);
			response.setStatus(true);
			response.setException(false);
			response.setResponseDataList(objects);
			response.setResponseMessage("Students data are fetched successfully");
			return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setException(true);
			response.setResponseMessage(ex.toString());
			response.setStatus(false);
			return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ApiResponse> getStudentById(@PathVariable(value="id") int id) {
		ApiResponse response = new ApiResponse();
		response.setException(false);
		try {
			Student student = new Student();
			student = studentService.getStudentById(id);
			response.setStatus(true);
			response.setException(false);
			response.setResponseMessage("Student found");
			response.setResponseData(student);
			return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setException(true);
			response.setResponseMessage(ex.toString());
			response.setStatus(false);
			return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/student/save", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ApiResponse> saveStudent(@RequestBody Student student) {
		ApiResponse response = new ApiResponse();
		response.setException(false);
		try {
			Student savedStudent = this.studentService.addStudent(student);
			response.setStatus(true);
			response.setException(false);
			response.setResponseData(savedStudent);
			response.setResponseMessage("Student saved successfully");
			return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setException(true);
			response.setResponseMessage(ex.toString());
			response.setStatus(false);
			return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/student/update", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ApiResponse> updateStudent(@RequestBody Student student) {
		ApiResponse response = new ApiResponse();
		response.setException(false);
		try {
			Student savedStudent = this.studentService.addStudent(student);
			response.setStatus(true);
			response.setException(false);
			response.setResponseData(savedStudent);
			response.setResponseMessage("Student updated successfully");
			return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setException(true);
			response.setResponseMessage(ex.toString());
			response.setStatus(false);
			return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/student/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<ApiResponse> deleteStudentById(@PathVariable(value="id") int id) {
		ApiResponse response = new ApiResponse();
		response.setException(false);
		try {
			Student student = new Student();
			boolean deleteStatus = studentService.deleteStudentById(id);
			response.setStatus(deleteStatus);
			response.setException(false);
			response.setResponseData(student);
			response.setResponseMessage("Student with id "+id+" deleted successfully");
			return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setException(true);
			response.setResponseMessage(ex.toString());
			response.setStatus(false);
			return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		}
	}
	
	

}
