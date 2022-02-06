package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

//	@Before("logAnnotationMethod()")
	@Before("classAnnotation()")
	public void logAdvice(JoinPoint jp) {
		System.out.println(">>> Log: " + jp);
	}
	// method level point cut
	@Pointcut("@annotation(app.core.annotations.MyLogAnnotation)")
	public void logAnnotationMethod() {
		
	}
	// class level - for annotation on class
	@Pointcut("@target(app.core.annotations.MyLogAnnotation)")
	public void classAnnotation() {
		
	}
//	@Before("execution(* *.find(..))")
//	public void logAdvice(JoinPoint jp) {
//		System.out.println("*** Log: " + jp);
//	}
}
