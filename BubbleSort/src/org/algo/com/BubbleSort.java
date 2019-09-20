package org.algo.com;

public class BubbleSort {

	public static void main(String[] args) {
		int[] intArray = {20, 12, -5, 35, 1, -32, 14};
		int count = 0;
		for(int i=intArray.length -1 ; i > 0; i--) {
			for(int j=0; j < i; j++) {
				count++ ;
				if(intArray[j] > intArray[j+1]) {
					swap(intArray, j, j+1);
				}
			}
		}
		
		for(int a: intArray) {
			System.out.println(a);
		}
		System.out.println("\n\nTotal count done: "+count);

	}
	
	public static void swap(int[] arr, int i, int j) {
		if(i == j) {
			return;
		}
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

}
