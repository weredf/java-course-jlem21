package app.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Person;
import app.core.repository.PersonRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	// Create
	public int addPerson(Person person) {
		Optional<Person> opt = this.personRepository.findById(person.getId());
		if(opt.isEmpty()) { // otherwise repository can update instead of add
		person = this.personRepository.save(person); // values synchronized with database
		return person.getId();
		} else {
			throw new RuntimeException("add failed - person id " + person.getId() + " already exists");
		}
	}
	
	// Read
	public Person find(int id) {
		Optional<Person> opt = this.personRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new RuntimeException("find failed - person id " + id + " not found");
		}
	}
	
	// Update
	public void update(Person person) {
		Optional<Person> opt = this.personRepository.findById(person.getId());
		if(opt.isPresent()) {
			this.personRepository.save(person); // because this entity exists in database it is updated automatically
		} else {
			throw new RuntimeException("update failed - person id " + person.getId() + " not found");
		}
	}
	
	// Delete
	public void delete(Person person) {
		Optional<Person> opt = this.personRepository.findById(person.getId());
		if(opt.isPresent()) {
			this.personRepository.delete(person);
		} else {
			throw new RuntimeException("delete failed - person id " + person.getId() + " not found");
		}
	}
	
	
}
