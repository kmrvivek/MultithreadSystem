package org.ds.doubly_linked_list;

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

		EmployeeDoublyLinkedList employeeList = new EmployeeDoublyLinkedList();

		employeeList.addToFront(maryJane);
		employeeList.addToFront(rossalie);
		employeeList.addToFront(lilyEvans);
		employeeList.addToFront(emily);
		employeeList.addToTail(bill);

		System.out.println(TextColor.ANSI_GREEN);
		employeeList.printList();
		System.out.println("\n" + employeeList.getSize());

		System.out.println("Is Empty: " + employeeList.isEmpty());

//		employeeList.removeFromFront();
//
//		System.out.println(TextColor.ANSI_BLUE);
//		System.out.println("\n" + employeeList.getSize());
//		employeeList.printList();
//		System.out.println("Is Empty: " + employeeList.isEmpty());
//
//		employeeList.removeFromEnd();

//		System.out.println(TextColor.ANSI_GREEN);
//		System.out.println("\n" + employeeList.getSize());
//		employeeList.printList();
//		System.out.println("Is Empty: " + employeeList.isEmpty()+"\n\n");

		System.out.println(employeeList.addBeforeEmployee(lilyEvans, rose));
		System.out.println(employeeList.addBeforeEmployee(emily, sheldon));
		System.out.println(TextColor.ANSI_BLUE);
		System.out.println("\n" + employeeList.getSize());
		employeeList.printList();
		System.out.println("Is Empty: " + employeeList.isEmpty());
	
	}

}
