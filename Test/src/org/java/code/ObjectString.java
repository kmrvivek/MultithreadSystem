package org.java.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectString {

	public static void main(String[] args) {
		
		int n = 3 ;
		int m = 5;
		
		int[][] marks = {{85, 90, 60, 70, 80}, {75, 80, 50, 70, 80}, {95, 80, 80, 75,80}};
		
		List<Integer> arr = new ArrayList<>();
		
		int value =0;
		for(int i=0; i<m; i++) {
			value = 0;
			System.out.println("************New Row***"+i);
			for(int j=0; j<n; j++) {
				System.out.println("marks: "+i+" : "+j+" = "+marks[j][i]);
				 value +=marks[j][i];
			}
		arr.add(value);
			
		}

		for(int a: arr) {
			System.out.print(a+" ");
		}
		int avg = arr.get(0);
		int index = 0;
		for(int k=1; k<arr.size(); k++) {
			if(arr.get(k) < avg) {
				avg = arr.get(k);
				index = k;
			}
		}
		
		System.out.println("\n\nLowest value is "+avg+" and index is "+index);
		
		int[] result = new int[n];
		
		
		for(int i=0; i<n; i++) {
			value = 0;
			System.out.println("************Result row New Row***"+i);
			for(int j=0; j<m; j++) {
				if(j != index) {
					System.out.println("marks: "+i+" : "+j+" = "+marks[i][j]);
					 value +=marks[i][j];
				}
				
			}
		result[i] = value;
			
		}
		
		System.out.println("Final result: \n");
		
		for(int a : result) {
			System.out.print(a+" ");
		}
		
	}
	
	

}
