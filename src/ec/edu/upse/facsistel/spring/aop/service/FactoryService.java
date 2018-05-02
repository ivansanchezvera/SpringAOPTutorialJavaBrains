package ec.edu.upse.facsistel.spring.aop.service;

import ec.edu.upse.facsistel.spring.aop.model.Circle;
import ec.edu.upse.facsistel.spring.aop.model.Triangle;

public class FactoryService {

	public Object getBean(String beanType)
	{
		if(beanType.equals("shapeService")) return new ShapeServiceProxy();
		if(beanType.equals("circle")) return new Circle();
		if(beanType.equals("triangle")) return new Triangle();
		return null;
		
		
	}
}
