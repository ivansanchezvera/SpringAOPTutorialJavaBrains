package ec.edu.upse.facsistel.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	//@After("args(name)") //Executes wether the method executes successfully or not.
	@AfterReturning(pointcut="args(name)", returning="returnString") //Executes only whenn a method executes successfully.
	public void stringArgumentMethods(String name, String returnString) {
		System.out.println("A method that takes string arguments has been called. The value is: " + name + ", the returned value is: " + returnString);
	}
	
	//Advice executes only when exception is thrown
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void exceptionAdvice(String name, Exception ex)
	{
		System.out.println("An exception has been thrown!" + " Exception is: " + ex.toString());
	}
	
	//Wraps the method, both before and after. That's why it's called around advice.
	//Around advice needs a compulsory method as a parameter, AKA Proceeding Joint Point
	@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
		//Proceed method actually executes the method this advice is wrapping.
		Object returnValue = null;
		try {
			System.out.println("Before advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After Returning");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("After Throwing");
			e.printStackTrace();
		}
		
		System.out.println("After Finally");
		return returnValue;
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
