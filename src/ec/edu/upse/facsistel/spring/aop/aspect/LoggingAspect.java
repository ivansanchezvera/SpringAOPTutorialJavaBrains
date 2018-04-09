package ec.edu.upse.facsistel.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint)
	{
		//get target of a joinPoint gives a handle on the object to which the method being wrap belongs to.
		System.out.println(joinPoint.getTarget());
	}
	
	@Before("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("A method that takes string arguments has been called. The value is: " + name);
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
