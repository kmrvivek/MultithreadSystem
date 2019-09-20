package org.read.expense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		
		File file = new File("E:\\expense.txt");
		BufferedReader br = null; 
		
		Map<String, Double> expense = new HashMap<>();
		
		try {
			br = new BufferedReader(new FileReader(file));
			 String st;
			  while ((st = br.readLine()) != null) {
				  
				  System.out.println(st);
				  
				 String[] arr = st.split(" ");
				 String[] date = arr[0].split("/");
				 double exp = calculate(Double.parseDouble(arr[1]));
				 System.out.println("Redifened value : "+exp);				 
				 if(expense != null &&  expense.containsKey(date[1])) {					
					double sum = expense.get(date[1]);
					sum += exp;
					expense.put(date[1], sum);
				 } else {
					 expense.put(date[1], Double.parseDouble(arr[1]));
				 }
				
			    	
			  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			br.close();
		}
		
		printMonthExpense(expense);

	}

	private static void printMonthExpense(Map<String, Double> expense) {
		for(Map.Entry<String, Double> entry: expense.entrySet()) {
			System.out.println("*************************************");
			
			if(entry.getValue() >= 100 && entry.getValue() < 200) {
				System.out.println(entry.getValue());
				double ex = entry.getValue() - 10 ;
				System.out.println("Month: "+entry.getKey()+" : Expense: "+ex);
			} 
			if(entry.getValue() >= 200 && entry.getValue() < 300) {
				System.out.println(entry.getValue());
				double ex = entry.getValue() - 50 ;
				System.out.println("Month: "+entry.getKey()+" : Expense: "+ex);
			}
			
			 if(entry.getValue() >= 300 && entry.getValue() < 500) {
				 System.out.println(entry.getValue());
				double ex = entry.getValue() - 100 ;
				System.out.println("Month: "+entry.getKey()+" : Expense: "+ex);
			}
			 
			  if(entry.getValue() >= 500 ) {
				  System.out.println(entry.getValue());
					double ex = entry.getValue() - 150 ;
					System.out.println("Month: "+entry.getKey()+" : Expense: "+ex);
				}
		}
		
	}

	private static double calculate(double d) {
		System.out.println("original price: "+d);
		System.out.println(1/2);
		double price = 0;
		if(d < 100) {
			price = d;
		} else if(d>=100 && d < 200) {
			price = d - (d*0.1);
		} else if(d>=200 && d<300) {
			price = d - (d*0.15);
		} else if(d >300) {
			price = d - (d*0.2);
		} else {
			price = 0;
		}
		return price;
		
	}

}
