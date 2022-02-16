package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import app.core.beans.MyBean;

@Configuration
@ComponentScan
public class App3 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App3.class);
		// ctx is the container
		// how many beans of the type MyBean are there in the container?
		// 4 (1 hardcoded, 3 beans)
		
		ctx.close();
	}
	
	
	@Bean
	public MyBean b1() {
		MyBean b1 = new MyBean();
		b1.value = 1;
		return b1;
	}
	@Bean
	public MyBean b2() {
		MyBean b1 = new MyBean();
		b1.value = 2;
		return b1;
	}
	@Bean
	public MyBean b3() {
		MyBean b1 = new MyBean();
		b1.value = 3;
		return b1;
	}

}
