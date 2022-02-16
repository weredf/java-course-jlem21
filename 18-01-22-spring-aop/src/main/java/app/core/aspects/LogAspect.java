package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class LogAspect {

	// below is an advice method of type "before"
	// it has an annotation @Before
	// the annotation has a pointcut expression [execution(void addCompany(int,
	// String))]

	// specific
	@Before("execution(void addCompany(int, String))")
	public void logAdviceSpecific() {
		System.out.println(">>> Log specific for addCompany(int, String)");
	}
	
	@Before("execution(void add*(..))")
	public void logAdviceSpecificAdd() {
		System.out.println(">>> Log specific for all addmethods");
	}

	// most general
	@Before("execution(* *.*(..))")
	public void logAdviceGeneral() {
		System.out.println(">>> Log for all methods");
	}
	
	@Before("execution(* *.*(*, *))")
	public void logAdviceTwoParameters() {
		System.out.println(">>> Log for methods with 2 parameters");
	}

	@Before("execution(* *.*())")
	public void logAdviceNoParameters() {
		System.out.println(">>> Log for methods without parameters");
	}
	
	@Before("execution(* add*())")
	public void logAdviceSpecificAddNoParameters() {
		System.out.println(">>> Log specific for all addmethods without parameters");
	}
	
	@Before("execution(* do*(..))")
	public void logAdviceSpecificDo() {
		System.out.println(">>> Log specific for all domethods");
	}
	
	@Before("execution(* *.*d*(..))")
	public void logAdviceSpecific(JoinPoint jp) {
		System.out.println(">>> Log for method name: " +jp.getSignature().getName());
	}
	
	@Before("execution(* *.*(int))")
	public void logAdviceSpecificIntParameter() {
		System.out.println(">>> Log specific for methods with int parameter");
	}
}
