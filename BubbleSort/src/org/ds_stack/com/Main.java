package org.ds_stack.com;

import org.algo.com.TextColor;

public class Main {

	public static void main(String[] args) {

		Employee maryJane = new Employee("Mary", "Jane", 4523);
		Employee rossalie = new Employee("Rosalie", "Emrose", 2145);
		Employee lilyEvans = new Employee("Lily", "Evans", 22);
		Employee emily = new Employee("Emily", "Clarke", 145);
		Employee bill = new Employee("Bill", "Bobs", 115);
		
		Employee rose = new Employee("Rose", "Mary", 221);
		Employee sheldon = new Employee("Sheldon", "Cooper", 221);

		ArrayStack employeeList = new ArrayStack(10);
		employeeList.push(rossalie);
		employeeList.push(emily);
		employeeList.push(lilyEvans);
		employeeList.push(rose);
		employeeList.push(bill);
		employeeList.push(sheldon);

	
		System.out.println(TextColor.ANSI_BLUE);
		System.out.println(employeeList.getSize());
		employeeList.printStack();
		
		System.out.println(TextColor.ANSI_GREEN);
		System.out.println("\n" + employeeList.getSize());
		System.out.println(employeeList.peek());
		
		System.out.println(TextColor.ANSI_BLUE);
		System.out.println(employeeList.pop());
		System.out.println("\n" + employeeList.getSize());
		employeeList.printStack();
	
	}

}
