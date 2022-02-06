package app.core.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.core.entities.Student;

// custom methods
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	// 1. Query methods
	
	// native sql
	@Query(value = "select * from students where the_gender = 'F'", nativeQuery=true)
	List<Student> getFemales();
	
	// JSQL - a form of sql that is Entity oriented (not table oriented)
	@Query(value = "from Student where gender='M'")
	List<Student> getMales();
	
	@Query(value = "from Student where gender='M'")
	List<Student> getMales(Sort sort);
	
	@Query(value = "from Student where age > :age")
	List<Student> getOlderThan(int age);
	
	// 2. Derived methods - get their meaning by method name
	// introducer: key word to say what we want
	// criteria: how (make sure to use right attributed fields)
	List<Student> findByName(String name);

	List<Student> findByActiveIsTrue();

	List<Student> findByActiveIsFalse();
}
