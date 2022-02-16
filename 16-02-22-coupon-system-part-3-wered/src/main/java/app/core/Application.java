package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.core.exceptions.CouponSystemException;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableScheduling
public class Application {

	public static void main(String[] args) throws CouponSystemException, InterruptedException {
		SpringApplication.run(Application.class, args);
		
	}
}
