package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import app.core.exceptions.CouponSystemException;
import app.core.filters.ClientFilter;
import app.core.jwt.util.JwtUtil;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableScheduling
public class Application {

	public static void main(String[] args) throws CouponSystemException, InterruptedException {
		SpringApplication.run(Application.class, args);
	}
	
	// register and map the filter
		@Bean
		public FilterRegistrationBean<ClientFilter> clientFilter(JwtUtil jwtUtil) {
			// container for registering filters
			FilterRegistrationBean<ClientFilter> filterRegistrationBean = new FilterRegistrationBean<>();
			// register our filter - set the filter
			ClientFilter clientFilter = new ClientFilter(jwtUtil);
			filterRegistrationBean.setFilter(clientFilter);
			// map the filter to route (a url pattern)
			filterRegistrationBean.addUrlPatterns("/api/*");
			// return the set and routed FilterRegistrationBean
			return filterRegistrationBean;
		}
}
