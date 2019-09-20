package org.algo.com;

import java.util.Arrays;

public class JdkArraySort {

	public static void main(String[] args) {
		
		int[] intArray = {20, 12, -5, 35, 1, -32, 14};
		
		Arrays.sort(intArray);
		
		
	int[]	intArray2 = {20, 12, -5, 46, 1, -62, 14};
	
	Arrays.parallelSort(intArray2);
		
		for(int i: intArray) {
			System.out.print(i+"  ");
		}
		
		System.out.println("\n\n Parallel Sort: ");
		for(int i: intArray2) {
			System.out.print(i+"  ");
		}


	}

}
