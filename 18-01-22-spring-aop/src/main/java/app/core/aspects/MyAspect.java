package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class MyAspect {

	// five types of advice: before, after, after returning, after throwing, around 
	
	@Before("div()")
	public void beforeDivAdvice(JoinPoint jp) {
		System.out.println(">>> before" + jp);
	}
	
	@After("div()")
	public void afterDivAdvice(JoinPoint jp) {
		System.out.println(">>> after" + jp);
	}
	
	@AfterReturning(pointcut = "div()", returning = "res")
	public void afterReturnDivAdvice(JoinPoint jp, String res) {
		System.out.println(">>> after returning" + jp + " [result is " + res + "]");
	}

	@AfterThrowing(pointcut = "div()", throwing = "e")
	public void afterThrowingDivAdvice(JoinPoint jp, Throwable e) {
		System.out.println(">>> after throwing" + jp + " [exception is " + e + "]");
	}

	@Around("div()")
	public String aroundDivAdvice(ProceedingJoinPoint pjp) {
		System.out.println(">>> around - before " + pjp);
		// run the join point (business method) using proceed
		Object res;
		try {
			res = pjp.proceed();
			System.out.println(">>> around - after return " + res);
			return res.toString();
		} catch (Throwable e) {
			return " around: divide failed";
		} finally {
			System.out.println(">>> around - after " + pjp);
		}
	}
	
	@Pointcut("execution(* *.div(..))")
	public void div() {
		
	}
}
