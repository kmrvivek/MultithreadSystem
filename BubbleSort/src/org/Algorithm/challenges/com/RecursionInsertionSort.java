package org.Algorithm.challenges.com;

public class RecursionInsertionSort {

	public static void main(String[] args) {
		
		int[] intArray = {20, 35, -15, 7, 55, 1, -22 };
		
		insertionSort(intArray, intArray.length);		
		for(int a: intArray) {
			System.out.print(a+"\t");
		}
	}
	
	public static void insertionSort(int[] input, int numItems) {
		if(numItems < 2) {
			return ;
		}
		
		insertionSort(input, numItems-1);
		
		int newElement = input[numItems - 1];
		
		int i;
		
		for(i = numItems -1; i > 0 && input[i-1] > newElement; i--) {
			input[i] = input[i-1];
		}
		
		input[i] = newElement;
		
		System.out.println("Result of call when num Items = "+numItems);
		for(int k: input) {
			System.out.print(k);
			System.out.print(", ");
		}
		
		System.out.println("");
		System.out.println("-------------------------");
		
	}

}
