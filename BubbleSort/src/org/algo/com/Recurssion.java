package org.algo.com;

public class Recurssion {

	public static void main(String[] args) {
		
		System.out.println("Using recursion value of 4!= "+recursionFactorial(4));
		
		System.out.println("\nUsing iteration value of 4!= "+iterativeFactorial(4));
	}
	
	public static int recursionFactorial(int num) {
		if(num == 0) {
			return 1;
		}
		
		return num * recursionFactorial(num -1);
	}
	
	public static int iterativeFactorial(int num) {
		if(num == 0) {
			return 1;
		}
		int factorial = 1;
		
		for(int i=1; i <= num ; i++) {
			factorial = factorial * i ;
		}
		
		return factorial;
	}

}
