package com.nikhil.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.model.Student;

public interface StudentRepositry extends JpaRepository<Student, Integer> {

}
