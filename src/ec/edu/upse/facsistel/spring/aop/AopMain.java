package ec.edu.upse.facsistel.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ec.edu.upse.facsistel.spring.aop.service.ShapeService;

public class AopMain {
	
	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		shapeService.getCircle();
		
		//To try args pointcut:
		//shapeService.setCircle(new Circle());
		
		
		
	}
}
