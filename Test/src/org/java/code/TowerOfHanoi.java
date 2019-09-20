package org.java.code;

public class TowerOfHanoi {

	  public static void main(String args[]) {
	        print(4, "A", "C", "B");
	      }
	    
	    static void print(int n, String a, String b, String c){
	     
	    
	       if(n == 1){
	              System.out.println("1 moved from "+a+" to "+b);
	              return;
	          }
	        
	         
	          print(n-1, a, c, b);
	        System.out.println(n +" moved from "+a+" to "+b);
	        print(n-1, c, b, a);
	       
	        
	      
	    }
	    
}
