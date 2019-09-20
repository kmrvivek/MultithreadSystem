package org.java.code;

import java.util.*;
import java.io.*;
import java.time.DayOfWeek;

class Solution {
    


public static int getDay(String day, String month, String year){
	Calendar cal = Calendar.getInstance();  
    cal.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    int d = cal.get(Calendar.DAY_OF_WEEK);
        return d;
}
    	
        
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String month = in.next();
            String day = in.next();
            String year = in.next();
            
            System.out.println(getDay(day, month, year));
        }
    
    }
    
 
