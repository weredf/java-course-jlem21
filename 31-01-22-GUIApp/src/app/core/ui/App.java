package app.core.ui;

import app.core.model.User;

public class App {

	public static void main(String[] args) {
		
		User user = new User();
		user.setEmail("aaa@mail.com");
		user.setPassword("aaaPass");
		
		System.out.println(user);
	}

}
