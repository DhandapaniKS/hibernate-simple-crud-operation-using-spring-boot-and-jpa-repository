package com.dhandapani.hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhandapani.hibernate.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
