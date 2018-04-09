package ec.edu.upse.facsistel.spring.aop.model;

public class Circle {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Setter of name attribute in circle begins.");
		this.name = name;
		throw(new RuntimeException());
	}
	
	public String setNameAndReturn(String name) {
		System.out.println("Setter of name attribute in circle begins and it will return!");
		this.name = name;
		return name;
	}
}
