package com.codemyth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemyth.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
