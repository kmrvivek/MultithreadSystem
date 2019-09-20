package org.java.code;

public class JosephusProblem {
	   public static void main(String args[]) {
	        int n = 7; 
	    int k = 3; 
	    System.out.println("The chosen place is " + josephus(n, k)); 
	      }
	    
	    static int josephus(int n, int k){
	     if(n ==1){
	         return 1;
	     }
	       return ((josephus(n-1, k) + k-1)%n +1);
	      
	    }
}
