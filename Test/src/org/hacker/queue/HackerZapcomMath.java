package org.hacker.queue;

import java.util.ArrayList;
import java.util.List;

public class HackerZapcomMath {

	public static void main(String[] args) {
		int n = 4;
		int arr[] = {1,2,3,5};
		int th = 1;
		int min = arr[0];
		List<Integer> difList = new ArrayList<>();
		int num = 0;
		boolean found = false;
		for(int i=1; i<n; i++) {
			int diff = arr[i] - min;
			difList.add(diff);
			if(diff == th) {
				num = diff+min;
				found = true;
			}
		}
		
		if(!found) {
			System.out.println("Value not found "+n);
		} else {
			int i =2;
			int count = 1;
			while(i < n) {
				count++;
				if(arr[i] < num) {
					i++;
					i++;					
					
				}else if(arr[i] > num) {
					i--;
					count--;
					break;
				} else {
					found = true;
					break;
				}
				
			}
			
			if(i >= n && arr[i-1] == num) {
				System.out.println("value found "+(count+1));
			} else {
				System.out.println("value found "+count);
			}
		}
	}

}
