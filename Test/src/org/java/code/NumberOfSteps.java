package org.java.code;

import java.util.Scanner;

public class NumberOfSteps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
		System.out.println(numberOfOperation(sc.nextInt(), 0));
		}
		sc.close();

	}

	 static int numberOfOperation(int n, int steps){
	     if(n <= 1){
	         return 0;
	     } 
	   
	     
	     if(n % 2 == 0){
	          return (steps+1 + numberOfOperation(n/2, steps)); 
	     }
	     
	     return (steps+1 + numberOfOperation(n-1, steps));
	     
	 }
}
