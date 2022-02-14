package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.core.exceptions.CouponSystemException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws CouponSystemException {
		SpringApplication.run(Application.class, args);
	}
}
