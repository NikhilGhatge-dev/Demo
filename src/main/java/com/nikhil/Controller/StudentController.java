package com.nikhil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nikhil.Service.IStudentService;
import com.nikhil.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@GetMapping("/register")
	public String showRegister() {
		
		return "StudentRegister";
	}
	
	/***
	 * 2.This is method will read form data as ModelAttribute 
	 * 	 performs save() opertion using service that returns ID generated
	 *   Construct one message and send UI using Model memory
	 *   On Entering URL : /save with TYPE :POST
	 */
	@PostMapping("/save")
	public String saveStudent(
			@ModelAttribute Student student,
			Model model) {
		Integer id=service.saveStuent(student);
		String message="Student"+id+"saved";
		model.addAttribute("message",message);
		return "StudentRegister";
	}
	
	/**
	 * 3. This method gets data from Db using service
	 * and send to UI using Model..It is called when 
	 * PATH: /all with type GET is reqiuired..
	 * 
	 */
	@GetMapping("/all")
	public String showData(Model model) {
	  List<Student> list=service.getAllStudent();
	  //sending to UI
	  model.addAttribute("list",list);
	  return "StudentData";
	}
	
	/***
	 * 4. This is method go to database and 
	 * delete to records and display remaining
	 * @param model records and also generate message
	 * @return
	 */
	@GetMapping("/delete")
	public String deleteStudent(
			@RequestParam Integer id,Model model) 
	{
	   //call service
		service.deleteStudent(id);
		//send deatils by UI
		model.addAttribute("message","student'"+id+"' deleted");
		model.addAttribute("list",service.getAllStudent());
	   return "StudentData";		
	}
	
	/**
	 * 5 . show Edit page on click edit hyperlink
	 *  re:/student/edit?10,Type :Get
	 *  Read Object from DB using PK(Id) sent it to 
	 *  editfrom
	 */
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id,
			              Model model) {
		Student s=service.getOneStudent(id);
		model.addAttribute("student",s);
		return "StudentEdit";
	}
	
	/**
	 * 6. on click update button,Read from data as model Attribute employee
	 * send to to database 
	 * using service,redirect to all
	 * [Response,sendRedirect]
	 */
	
	@PostMapping("/update")
	public String updateStudent(
			@ModelAttribute Student student,
			Model model) 
	{
	   //call service
		service.updateStudent(student);
		//send deatils by UI
		model.addAttribute("message","student'"+student.getId()+"' updated");
		model.addAttribute("list",service.getAllStudent());
	   return "StudentData";		
	}
}
   