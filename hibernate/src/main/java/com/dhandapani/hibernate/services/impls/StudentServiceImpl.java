package com.dhandapani.hibernate.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhandapani.hibernate.models.Student;
import com.dhandapani.hibernate.repositories.StudentRepository;
import com.dhandapani.hibernate.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepository.findOne(id);
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public boolean deleteStudentById(int studentId) {
		studentRepository.delete(studentId);
		return true;
	}

}
