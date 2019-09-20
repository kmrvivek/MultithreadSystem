package org.hacker.queue;

public class MyClass {
    public static void main(String args[]) {
      
       int val = doRecursion( 23, 9, 11, 12);
       System.out.println(val);
    }
    
    public static int doRecursion(int n, int a, int b, int c){
        if(n < 0){
          return -1;  
        }
        if(n == 0) {
        return 0;
        }
        System.out.println("n: "+n+"  a : "+a+"  b : "+b+"  c:  "+c);
        int ca = doRecursion(n-a, a, b, c);
        int cb = doRecursion(n-b, a, b, c);
        int cc = doRecursion(n-c, a, b, c);
        
       int res = getMax(ca, cb, cc);
       if(res == -1) {
       return -1;
       }  else {
       return res+1;
       }
        
    }
    
    public static int getMax(int a, int b, int c){
    	
    	  System.out.println("====>  a : "+a+"  b : "+b+"  c:  "+c);
        if(a > b && a > c) {
        return a;
        } else if(b > c) {
        return b;
        }
       
        else {
        return c;
        }
        
    }
}

