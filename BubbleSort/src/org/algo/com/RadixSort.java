package org.algo.com;

public class RadixSort {

	public static void main(String[] args) {
		
		int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };
		
		radixSort(radixArray, 10, 4);
		
		for(int i: radixArray) {
			System.out.print(i+"  ");
		}
	}
	
	public static void radixSort(int[] input, int radix, int width) {
		for(int i=0; i < width; i++) {
			radixSingleSort(input, i, radix);
		}
		
	}

	private static void radixSingleSort(int[] input, int position, int radix) {
		
		int numItems = input.length;		
		int[] countArray = new int[radix];
		
		for(int value: input) {
			int k = getDigit(position, value, radix);
			countArray[k]++ ;
		}
		System.out.println("\n");
		
		for(int i: countArray) {
			System.out.print(i+"  ");
		}
		
		System.out.println("\n");
		
		// Adjust the count array
		for(int j = 1; j < radix; j++) {
			countArray[j] += countArray[j-1];
			
		}
		System.out.println("\nAdjusting the count array: ");
		for(int i: countArray) {
			System.out.print(i+"  ");
		}
		
		System.out.println("\n");
		
		int[] temp = new int[numItems];
		for(int tempIndex = numItems- 1 ; tempIndex >= 0; tempIndex-- ) {
			
			System.out.println("\nNow checking position: "+position+" input[tempIndex]: "+input[tempIndex]);
			int l = --countArray[getDigit(position, input[tempIndex], radix)];
			System.out.println("Before arranging the original value the temp[l]: "+temp[l]);
			temp[l] = input[tempIndex];
			
			System.out.println("Creating and arranging original for value at l\n position: "+l
					+ " for the value to "+temp[l]+"\n");
		}
		
		for(int tempIndex = 0; tempIndex < numItems; tempIndex++) {
			System.out.println("\nBefore setting final value at input[tempIndex]: "+input[tempIndex]);
			input[tempIndex] = temp[tempIndex];
			System.out.println("After setting final value at input[tempIndex]: "+input[tempIndex]);
		}
		
	}

	private static int getDigit(int position, int value, int radix) {
		
		System.out.println("Value: "+value+" Position: "+position+" radix: "+radix);
		
		System.out.println("get digit value returns: "+value / (int)Math.pow(10, position)%radix);
		return value / (int)Math.pow(10, position)%radix;
	}



}
