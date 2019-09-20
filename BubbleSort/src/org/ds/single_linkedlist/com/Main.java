package org.ds.single_linkedlist.com;

import org.algo.com.TextColor;

public class Main {

	public static void main(String[] args) {
		
	Employee maryJane = new Employee("Mary", "Jane", 4523);
	Employee rossalie = new Employee("Rosalie", "Emrose", 2145);
	Employee lilyEvans = new Employee("Lily", "Evans", 22);
	Employee emily = new Employee("Emily", "Clarke", 145);
		
		
		EmployeeLinkedList employeeList = new EmployeeLinkedList();

		employeeList.addToFront(maryJane);
		employeeList.addToFront(rossalie);
		employeeList.addToFront(lilyEvans);
		employeeList.addToFront(emily);
		
		System.out.println(TextColor.ANSI_GREEN);
		employeeList.printList();
		System.out.println("\n"+employeeList.getSize());
		
		System.out.println("Is Empty: "+employeeList.isEmpty());
		
		employeeList.removeFromFront();
		
		System.out.println(TextColor.ANSI_BLUE);
		System.out.println("\n"+employeeList.getSize());
		employeeList.printList();		
		System.out.println("Is Empty: "+employeeList.isEmpty());
	}

}
