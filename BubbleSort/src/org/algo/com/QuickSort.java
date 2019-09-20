package org.algo.com;

public class QuickSort {

	public static void main(String[] args) {
		
		   int[] intArray = { 20, 35, -15, 55, 7, 1, -22  };

		   quickSort(intArray, 0, intArray.length);
	        for (int i = 0; i < intArray.length; i++) {
	            System.out.print(intArray[i]+"\t");
	        }
	}
	
	public static void quickSort(int[] input, int start, int end) {
		if(end - start < 2) {
			return;
		}
		
		int pivotIndex = partition(input, start, end);
		System.out.println("Pivot index now: "+pivotIndex+" now start: "
		+start+" now end: "+end);
		for(int k: input) {
			System.out.print(TextColor.ANSI_BLUE +k+"\t");
		}
		System.out.println("\n");
		quickSort(input, start, pivotIndex);
		quickSort(input, pivotIndex +1, end);
	}

	private static int partition(int[] input, int start, int end) {
		
		int pivot = input[start];
		int i = start;
		int j = end;
		
		while(i < j) {
			// NOTE: empty loop body
			while(i < j && 	input[--j] >= pivot);
			System.out.println(TextColor.ANSI_BLUE+ "i:" +i+", j:"+j);
			//System.out.println("\n");
				if(i < j) {
					input[i] = input[j];
					System.out.println("input[i] "+input[i] );
				}
			
				// Note: empty loop body
				while(i < j && input[++i] <= pivot);
				System.out.println(TextColor.ANSI_RED+"i:" +i+", j:"+j);
			//	System.out.println("\n");
				if(i < j) {
					input[j] = input[i];
					System.out.println("input[j] "+input[j] );
				}				
			}
		input[j] = pivot;
		
		return j;
	}

	
}
