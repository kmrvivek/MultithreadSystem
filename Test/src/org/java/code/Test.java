package org.java.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Test {
    public static void main(String args[] ) throws Exception {
      
       String res = "ab ba abc can bdeac acbde adcf";
       String[] anagram = res.split(" ");
        String result = findBiggestAnagram(anagram);
       System.out.println("final result: "+result);
      
   }
   
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
     
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str: strs){
            char[] arr = new char[26];
            for(int i=0; i<str.length(); i++){
            	System.out.println("word at "+str.charAt(i)+" : value :  ");
            	System.out.println(str.charAt(i)-'a');
                arr[str.charAt(i)-'a']++;
               
            }
            String ns = new String(arr);
            
            if(map.containsKey(ns)){
            	System.out.println("added in same ns: "+str);
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                System.out.println("different adding: "+str);
                al.add(str);
                map.put(ns, al);
            }
        }
     
        result.addAll(map.values());
     
        return result;
    }
    
    public static String findBiggestAnagram(String[] anagram)
    {
    	List<List<String>> allAnagrams = groupAnagrams(anagram);
    	System.out.println(allAnagrams.toString());
    	
        int biggestAnnagramCount = 0;
        String biggestAnnaGramWord = "";
        for (List<String> string : allAnagrams)
        {
            if(biggestAnnagramCount<string.get(0).length())
            {
                biggestAnnaGramWord = string.get(0);
                System.out.println(biggestAnnaGramWord);
                biggestAnnagramCount=string.get(0).length();
            }
        }
        return biggestAnnaGramWord;
    }
}
