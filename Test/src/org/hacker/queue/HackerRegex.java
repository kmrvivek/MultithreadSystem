package org.hacker.queue;

import java.util.Arrays;
import java.util.Scanner;

public class HackerRegex {


	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	    

	    String s = scan.nextLine();
	    
	    if (s == null || s.equals("") || s.trim().equals("")){
	       System.out.println("0");
	    } else{
	        String[] items = s.trim().split("[ !,?.\\_'@]+");
	        System.out.println(Arrays.toString(items));
	       System.out.println(items.length);
	      int k =0;
	        while(k < s.length()){
	        System.out.println(items[k]);
	        k++;
	        }
	    }
	        scan.close();
	    }
	}