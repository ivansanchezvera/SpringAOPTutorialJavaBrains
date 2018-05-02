package ec.edu.upse.facsistel.spring.aop.service;

import ec.edu.upse.facsistel.spring.aop.aspect.Loggabble;
import ec.edu.upse.facsistel.spring.aop.model.Circle;
import ec.edu.upse.facsistel.spring.aop.model.Triangle;

public class ShapeService {

	private Circle circle;
	private Triangle triangle;
	
	@Loggabble
	public Circle getCircle() {
		System.out.println("Circle Getter Called");
		return circle;
	} 
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
	
}
