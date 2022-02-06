package app.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Student;
import app.core.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	// Create
	public int addStudent(Student student) {
		Optional<Student> opt = this.studentRepository.findById(student.getId());
		if(opt.isEmpty()) { // otherwise repository can update instead of add
		student = this.studentRepository.save(student); // values synchronized with database
		return student.getId();
		} else {
			throw new RuntimeException("add failed - person id " + student.getId() + " already exists");
		}
	}
	
	// Read
	public Student find(int id) {
		Optional<Student> opt = this.studentRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new RuntimeException("find failed - person id " + id + " not found");
		}
	}
	
	// Update
	public void update(Student student) {
		Optional<Student> opt = this.studentRepository.findById(student.getId());
		if(opt.isPresent()) {
			this.studentRepository.save(student); // because this entity exists in database it is updated automatically
		} else {
			throw new RuntimeException("update failed - person id " + student.getId() + " not found");
		}
	}
	
	// Delete
	public void delete(Student student) {
		Optional<Student> opt = this.studentRepository.findById(student.getId());
		if(opt.isPresent()) {
			this.studentRepository.delete(student);
		} else {
			throw new RuntimeException("delete failed - person id " + student.getId() + " not found");
		}
	}
	
	public List<Student> getFemaleStudents() {
		return this.studentRepository.getFemales();
	}

	public List<Student> getMaleStudents() {
		return this.studentRepository.getMales();
	}

	public List<Student> getMaleStudents(Sort sort) {
		return this.studentRepository.getMales(sort);
	}
	
	public List<Student> getStudentsOlderThan(int age) {
		return this.studentRepository.getOlderThan(age);
		
	}
	
	public List<Student> getStudentsByName(String name) {
		return this.studentRepository.findByName(name);
	}
}
