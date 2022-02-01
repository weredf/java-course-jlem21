package app.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // bean definition, default scope is singleton!
public class BankSpring {

	private int id;
	
	public BankSpring() {
		super();
	}
	
	@Autowired
	public BankSpring(@Value("${bank.id}") int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "BankSpring [id=" + id + ", name=" + name + "]";
	}
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
