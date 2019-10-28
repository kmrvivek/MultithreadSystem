package org.lenskart.test;

public class InheritTest {

	public static void main(String[] args) {
		new Vivek();
		new Vivek().getEmployee();
		
		Employee em = new Employee();
		em.getDetails();
		Employee cm = new Vivek();
		cm.getDetails();
		
	}
	
	static {
		System.out.println("Main class");
	}

}

class Employee {
	
	static {
		System.out.println("Employee");
	}
	
	public void getEmployee() {
		System.out.println("Employee Base class");
	}
	
	public static void getDetails() {
		System.out.println("getDetails Base class");
	}
}

class Vivek extends Employee {
	static {
		System.out.println("Vivek");
	}
	
	@Override
	public void getEmployee() {
		System.out.println("Vivek Extend class");
	}
	
	public static void getDetails() {
		System.out.println("getDetails Vivek class");
	}
	
}
