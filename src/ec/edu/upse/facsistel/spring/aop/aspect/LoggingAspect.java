package ec.edu.upse.facsistel.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("allGetters()")
	public void loggingAdvice()
	{
		System.out.println("Advice run. Get Method called.");
	}
	
	@Before("allGetters()")
	public void secondAdvice()
	{
		System.out.println("Second advice mutherfucker!");
	}
	
	//This method is a dummy method, used to apply the point cut.
	//It kinda holds the pointcut.
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
}
