package com.nikhil.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Student_tab")
public class Student {
	@Id
	@Column(name = "stud_id_col")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "stud_name_col")
	private String name;
	
	@Column(name = "stud_marks_col")
	private float marks;
	
	@Column(name = "stud_address_col")
	private String addrs;
	
	@Column(name = "stud_email_col")
	private String email;
	
	@Column(name = "stud_gender_col")
	private String gender;
	
	@ElementCollection
	@CollectionTable(name="stud_subject_col",
	joinColumns = @JoinColumn(name="stud_name_col"))
	private List<String>subject;
	
	@ElementCollection
	@CollectionTable(name = "stud_grade_col",
	joinColumns = @JoinColumn(name="stud_name_col"))
	private List<String>grade;
	
}
