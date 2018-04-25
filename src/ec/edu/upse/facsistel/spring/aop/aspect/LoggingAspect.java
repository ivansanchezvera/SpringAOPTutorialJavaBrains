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

public class LoggingAspect {

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

}
