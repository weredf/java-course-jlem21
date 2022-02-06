package app.core.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Person;

@Component
@Transactional // start an EntityManager session on each method call and close it at the end
public class PersonDao {

	@Autowired
	private EntityManager em; // a container for persisting entities
	
	// Create
	public void addPerson(Person person) {
		em.persist(person);
	}
	
	// Read
	public Person find(int personId) {
		Person p = em.find(Person.class, personId);
		return p;
	}
	
	// Delete
	public void deleteById(int personId) {
		Person p = find(personId);
		em.remove(p);
	}
	
	// Update
	public void update(Person person) {
		Person personFromDb = find(person.getId());
		personFromDb.setName(person.getName());
		personFromDb.setAge(person.getAge());
	}
}
