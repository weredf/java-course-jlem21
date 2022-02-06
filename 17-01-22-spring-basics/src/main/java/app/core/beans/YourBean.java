package app.core.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class YourBean {

	public int value;	
	
	public YourBean() {
		System.out.println(">>> YourBean CTOR");
	}
	
	// action to do after bean is constructed
	@PostConstruct // life cycle hook annotation - tells container to call this method after bean is fully constructed
	public void doAfterConstruct() {
		System.out.println(">>>doAfterConstruct");
	}
	
	// action to do before bean is destroyed
	@PreDestroy // life cycle hook annotation - tells container to call this method before bean is destroyed - container shut down
	public void doBeforeDestroy() {
		System.out.println(">>>doBeforeDestroy");
	}
}
