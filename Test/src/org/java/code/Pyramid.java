package org.java.code;

public class Pyramid {

	public static void main(String[] args) {
		
		for(int i=0; i<4; i++) {
			for(int j=7-(i*2); j>0; j--) {
				System.out.print("*");
			}
			System.out.println("\n");
			printSpace(i+1);
		}
		
	
	}
	
	public static void printSpace(int k) {
		if(k == 0) {
			return;
		}
		
		System.out.print(" ");
		printSpace(k-1);
		
	}
}
