package org.ds_queue.com;

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

		ArrayQueue employeeList = new ArrayQueue(10);
		employeeList.add(rossalie);
		employeeList.add(emily);
		employeeList.add(lilyEvans);
		employeeList.add(rose);
		employeeList.add(bill);
		employeeList.add(sheldon);

	
		System.out.println(TextColor.ANSI_BLUE);
		System.out.println(employeeList.size());
		employeeList.printQueue();;
		
		System.out.println(TextColor.ANSI_GREEN);
		System.out.println("\n" + employeeList.size());
		System.out.println(employeeList.peek());
		
		System.out.println(TextColor.ANSI_BLUE);
		System.out.println(employeeList.remove());
		System.out.println(employeeList.remove());
		System.out.println(employeeList.remove());
		System.out.println(employeeList.remove());
		System.out.println(employeeList.remove());
		System.out.println(employeeList.remove());
		employeeList.add(maryJane);
		System.out.println("\n" + employeeList.size());
		employeeList.printQueue();
	
	}

}
