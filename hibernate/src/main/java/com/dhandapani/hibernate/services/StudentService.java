package com.dhandapani.hibernate.services;

import java.util.List;

import com.dhandapani.hibernate.models.Student;

public interface StudentService {
	public List<Student> getStudents();

	public Student getStudentById(int id);

	public Student addStudent(Student student);

	public Student updateStudent(Student student);

	public boolean deleteStudentById(int studentId);
}
