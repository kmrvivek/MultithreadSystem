package org.java.code;

import java.util.Scanner;

public class TestRecursiion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i<n; i++) {
			int digit = sc.nextInt();
			int low = (int) Math.floor(Math.sqrt(digit));
			if(low * low == digit) {
				low = low -1;
			}
			int high = low +1;
			
			if(high *high - digit > low *low -digit) {
				System.out.println(low * low);
			} else {
				System.out.println(high *high);
			}
		}
		sc.close();

	}
	
	


}
