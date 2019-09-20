package org.java.code;

import java.util.EnumMap;
import java.util.Map;
 
 
/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class EnumMapExample{
 
    public enum Days{
        Monday ,  Tuesday;
    	
    }
 
    public static void main(String args[]) {
  
        Map<Days, String> daysEnumMap = new EnumMap<Days, String>(Days.class);
 
        daysEnumMap.put(Days.Monday, "Day1");
        daysEnumMap.put(Days.Tuesday, "Day2");
 
           System.out.println("daysEnumMap.get(Days.Monday) : " +
                                             daysEnumMap.get(Days.Monday));
 
           System.out.println("daysEnumMap.containsKey(Days.Tuesday) : " +
                                             daysEnumMap.containsKey(Days.Tuesday));
 
    }
 
}
