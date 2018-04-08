package ec.edu.upse.facsistel.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("allCircleMethods()")
	public void loggingAdvice()
	{
		System.out.println("Advice run. Get Method called.");
	}
	
	@Before("allGetters()")
	public void secondAdvice()
	{
		System.out.println("Second advice mutherfucker!");
	}
	
	@Before("allMethodWithACircle()")
	public void circleDetectedAdvice()
	{
		System.out.println("Thats a circle mutherfucker!");
	}
	
	//This method is a dummy method, used to apply the point cut.
	//It kinda holds the pointcut.
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	//Applies advice to all methods within a class or set of classes (such as packages)
	@Pointcut("within(ec.edu.upse.facsistel.spring.aop.model.*)")
	public void allCircleMethods() {}
	
	//Applies advice to all methods that have a given argument.
	@Pointcut("args(ec.edu.upse.facsistel.spring.aop.model.Circle)")
	public void allMethodWithACircle() {}
	
	
}
