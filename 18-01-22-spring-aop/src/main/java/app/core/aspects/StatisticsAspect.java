package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StatisticsAspect {

	private int numberOfCalls;
	
	// advice match on any method that accepts Company parameter
	@Before("execution(* *.*(app.core.dao.company.Company))")
	public void counterAdvice(JoinPoint jp) {
		numberOfCalls++;
		System.out.println("   >>>" + jp);
	}
	
	// define point cuts to use on advice methods
	@Pointcut("execution(* *.*(app.core.dao.company.Company))")
	public void companyParam() {
		
	}
	
	@Pointcut("execution(* app.core.dao.company.*.*(..))")
	public void companyPackage() {
		
	}
	
	// this is not an advice method
	public int getNumberOfAddCalls() {
		return numberOfCalls;
	}
}
