package org.hahtable.com;

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

		SimpleHashTable ht = new SimpleHashTable();
		
		ht.put("Jones", maryJane);
		ht.put("Emily", emily);
		ht.put("Evans", lilyEvans);
		ht.put("Cooper", sheldon);
		ht.put("Bobs", bill);
		ht.put("Rossalie", rossalie);
		
		ht.printHashtable();
		
		System.out.println("**************************");
		
		System.out.println("Retireving the Lily Evans: "+ht.get("Evans"));
		
		System.out.println("**************************");
		
		ht.remove("Jones");
		ht.remove("Bobs");
		ht.remove("Emily");
		
		ht.printHashtable();
		

		System.out.println("**************************");
		
		System.out.println("Retireving the Lily Evans: "+ht.get("Evans"));
	}

}
