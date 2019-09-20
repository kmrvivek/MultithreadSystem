package org.java.code;

public class ReverseString {

	public static void main(String[] args) {
		
		String str = "My name is $Vivek Kumar$";
		
		String abc ="Let's party $tonight do$ at place";
		
		String[] arr = abc.split(" ");
		
		boolean find = true;
		int i = (arr.length)-1;
		while(find && i >=0) {
			if(arr[i].contains("$")) {
				String temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
				find = false;
			} else {
				i = i-1;;	
			}
			
			}
		
		for(int j= arr.length-1; j>=0;j--) {
			System.out.print(arr[j]+" ");
		}
			
		}


}
