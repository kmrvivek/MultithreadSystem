package org.Algorithm.challenges.com;

import java.util.*;

public class Lexicographic {
	

	    public static void main(String args[]) {
	        //if all caps then index -'A' if all small -'a' or if any char then arr = arr[256];
	        String x = "STRING";
	        
	        int[] count = new int[26];
	        
	        for(int i=0; i<x.length(); i++){
	            count[x.charAt(i)-'A']++;
	        }
	      /*  for(int i=0; i<26;i++){
	                System.out.println(i+1+"  == "+((char)(i+'A'))+ "  == "+count[i]);
	        }*/
	        // System.out.println(Arrays.toString(count));
	         for(int i=1; i<26; i++){
	            count[i] += count[i-1];
	        }

	        int val = 1;
	        for(int i=0; i<x.length(); i++){
	            int pos = x.charAt(i) - 'A';
	          
	            int mul;
	            if(pos == 0){
	                mul = 0;
	            } else {
	                mul = count[pos-1];
	            }
	            val += mul*fact(x.length()-(i+1));
	            updatecount(count, x.charAt(i));
	     
	        }
	      
	        System.out.println("Rank is  "+val);
	    }
	    
	     static void updatecount(int[] count, char ch) 
	    { 
	        int i; 
	        for (i = ch-'A'; i < 26; ++i) {
	            --count[i]; 
	        }
	    } 
	    
	    public static int fact(int n){
	        return (n<=1) ? 1 : n * fact(n-1);
	    }
	

}
