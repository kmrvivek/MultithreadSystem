package org.Algorithm.challenges.com;

public class ReverseMergeSort {

	public static void main(String[] args) {
		
		int[] intArray = {20, 12, -5, 35, 1, -32, 14};
		
		reverseMergeSort(intArray, 0, intArray.length);
		
		for(int a: intArray) {
			System.out.print(a+"  ");
		}
	}
	
	public static void reverseMergeSort(int[] input, int start, int end) {
		
		if(end - start < 2) {
			return ;
		}
		
		int mid = (start + end)/2;
		
		reverseMergeSort(input, start, mid);
		reverseMergeSort(input, mid, end);
		reverseMerge(input, start, end, mid);
	}

	private static void reverseMerge(int[] input, int start, int end, int mid) {
		
		if(input[mid-1] >= input[mid]) {
			return ;
		}
		
		int i = start;
		int j = mid;
		int tempIndex = 0;
		
		int[] tempArray = new int[end-start];
		
		while(i < mid && j < end) {
			tempArray[tempIndex++] = input[i] <= input[j] ? input[j++] : input[i++];
		}
		
		System.arraycopy(input, i, input, start+tempIndex, mid-i);
		System.arraycopy(tempArray, 0, input, start, tempIndex);
	}
	
	

}
