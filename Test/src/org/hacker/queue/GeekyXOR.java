package org.hacker.queue;

import java.util.*;
import java.io.*;

public class GeekyXOR
 {
	public static void main (String[] args)throws IOException
	 {
	   
	        int n = 10;
	        int arr[] = {5, 18, 9, 2, 11, 3, 15, 6, 32, 16};
	        int p = 6;
	        int q = 9;
	        System.out.println(Arrays.toString(arr));
	        System.out.println("final val  ==>  "+getXORAlternate(arr, n, p, q));
	        
	 }
	
	static int countSetBits(int n) { 
        int count = 0; 
        while (n > 0) { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
	 
	 public static int getXORAlternate(int[] arr, int n, int p, int q){
	     int i=0;
	     boolean isSkip = true;
	     int skip = 0;
	     int res = arr[0];
	     for(i=1; i< n; ){
	         
	         if(isSkip){
	             System.out.println("i is "+i);
	             int val  =(int) Math.pow(2, skip++);
	              System.out.println("value to be skipped  "+val);
	              int curr = i;
	             while(i<val+curr && i < n){
	                  System.out.println("Now i is  "+i);
	                 if(i <= p || i > q){
	                     System.out.println("Skipping the value  "+i+"  and element "+arr[i]);
	                     i++;
	                    continue;
	                 } 
	                 if(i<val+curr && i < n && i > p && i <= q){
	                	 int l = countSetBits(arr[i]);
	                    int sethBitNum = ((1 << l) | arr[i]); 
	                     System.out.println("Adding the i "+i+"  and set val is "+sethBitNum);
	                     res = res ^ sethBitNum;
	                     i++;
	                     
	                 } 
	             }
	             isSkip = false;
	         } else {
	             System.out.println("Adding the ith element "+i+ " number is "+arr[i]);
	             res = res ^ arr[i];
	             i++;
	             isSkip = true;
	             
	         }
	     }
	     
	     return res;
	 }
}