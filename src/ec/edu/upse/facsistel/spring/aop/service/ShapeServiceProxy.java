package ec.edu.upse.facsistel.spring.aop.service;

import ec.edu.upse.facsistel.spring.aop.aspect.LoggingAspect;
import ec.edu.upse.facsistel.spring.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	} 
}
