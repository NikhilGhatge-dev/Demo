package com.nikhil.Service;

import java.util.List;

import com.nikhil.model.Student;

public interface IStudentService {
	/** 1.
	 * This method read form data as model class
	 * @param s  indicate modelAttribute 
	 * @return Integer PK generated after save
	 */
	public Integer saveStuent(Student s);
	
	/**
	 * 2.
	 * this methods used to feacth Data from DataBase
	 * using findAll() methods and 
	 * List<Student> back to UI
	 */
	public List<Student> getAllStudent();
	
	/**
	 * 3.
	 * this are methods delete records 
	 *  using deleteById() and display 
	 * remaining records
	 */
	public void deleteStudent(Integer id);
	
	/**
	 * 4.
	 * this methods read in as input
	 * and returns Uom object else UOMelseNotFoundException
	 */
	public Student getOneStudent(Integer id);
	
	/***
	 * This method is used to update student based on Id(PK)
	 */
	public void updateStudent(Student stud);
}
