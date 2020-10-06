package com.nikhil.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.Repositry.StudentRepositry;
import com.nikhil.exception.StudentNotFoundException;
import com.nikhil.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepositry repo;
	
	@Override
	public Integer saveStuent(Student s) {
		//after save(obj) same object is returned with ID effected
		s=repo.save(s);
		return s.getId();
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list=repo.findAll();
		list.sort((e1,e2)->e1.getId() - e2.getId());
		return list;
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);	
	}

	@Override
	public Student getOneStudent(Integer id) {
		Student stud;
		stud=repo.findById(id)
				.orElseThrow(
					()->
					new StudentNotFoundException("Student'"+id+"'not updated")
					);
		return stud;
	}
	
	
	@Override
	public void updateStudent(Student stud) {
		repo.save(stud);	
	}

}
