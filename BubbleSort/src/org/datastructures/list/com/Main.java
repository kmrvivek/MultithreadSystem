package org.datastructures.list.com;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee("Mary", "Jane", 4523));
		employeeList.add(new Employee("Rose", "Troy", 2145));
		employeeList.add(new Employee("Lily", "Evans", 22));
		employeeList.add(new Employee("Emily", "Clarke", 145));
		
		//employeeList.forEach(employee -> System.out.println(employee));
		
		employeeList.set(2, new Employee("Rose", "Melia", 245));
		
		//employeeList.forEach(employee -> System.out.println(employee));
		
		//System.out.println(employeeList.isEmpty());
		
		employeeList.add(2, new Employee("Chris", "Evans", 314));
		
		//employeeList.forEach(employee -> System.out.println(employee));
		
//		Employee[] employArray = employeeList.toArray(new Employee[employeeList.size()]);
//		
//		for(Employee employee: employArray) {
//			System.out.println(employee);
//		}
		
		System.out.println(employeeList.contains(new Employee("Lily", "Evans", 22)));
		
		System.out.println(employeeList.indexOf(new Employee("Rose", "Melia", 245)));
		
		employeeList.remove(2);
		
		employeeList.forEach(employee -> System.out.println(employee));
	}

}
