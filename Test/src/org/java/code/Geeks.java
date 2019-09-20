package org.java.code;

public class Geeks {

	   public static void main(String args[]) {
	       int N = 8468;
	       double sum = 0.0;
	        for(int i=1; i <= N; i++){
	            sum = sum +Math.log10(i);
	        }
	        System.out.println((int)Math.floor(sum) + 1);
	       
	   }
	    
	}
