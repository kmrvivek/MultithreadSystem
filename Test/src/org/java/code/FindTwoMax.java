package org.java.code;import java.nio.file.SecureDirectoryStream;

public class FindTwoMax {

	public static void main(String[] args) {
	
		int[] arr = {12,15,11,123,28,35,43,23,11};
		
		int max = arr[0];
		
		int secondMax = arr[1];
		
		if(max < secondMax) {
			int temp = max;			
			max = secondMax;
			secondMax = temp;
		}
		
		
		System.out.println("max number is: "+max);
		System.out.println("2nd max is: "+secondMax);
		
		int i = 2;
		
		while(i < arr.length-1) {
			if(max < arr[i]) {
				max = arr[i];
				System.out.println("max number is: "+max);
			}
			
			if((secondMax < max) && secondMax < arr[i] && max != arr[i]) {
				secondMax = arr[i];
				
				System.out.println("2nd max is: "+secondMax);
				
			}
			
			System.out.println(i++) ;
		}
		
		System.out.println("*************************");
		
		System.out.println("max number is: "+max);
		System.out.println("2nd max is: "+secondMax);

	}

}
