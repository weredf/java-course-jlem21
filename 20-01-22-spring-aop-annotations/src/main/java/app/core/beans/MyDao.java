package app.core.beans;

import org.springframework.stereotype.Component;

import app.core.annotations.MyLogAnnotation;

@Component
@MyLogAnnotation // this annotation marks the class as join point
public class MyDao {

//	@MyLogAnnotation // this annotation marks the method as join point
	public void save() {
		System.out.println("dao is saving");
	}

	public void find(int id) {
		System.out.println("dao is saving " + id);
	}

	public void delete() {
		System.out.println("dao is deleting");
	}

}
