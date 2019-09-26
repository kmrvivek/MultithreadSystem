package org.hacker.queue;


import java.util.*;
public class NumberToWord {

 public static void main(String args[] ) throws Exception {
   
    
     Scanner s = new Scanner(System.in);
     long value = s.nextLong();
    
     System.out.println(value);
    String k = numberToString(value);
     System.out.println(k);
s.close();
 }
 
 static String[] arr = {"", "one ", "two ", "three ","four ","five ","six ","seven ", "eight ", "nine ", "ten ","eleven ","twelve ",
         "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ","eighteen ","nineteen "};
     
   static  String tens[] = {"","","twenty ", "thirty ","forty ","fifty ","sixty ","seventy ","eighty ","ninty "};
 
 static String numberToString(long n){
    StringBuffer sb = new StringBuffer();
     sb.append(numToString((int)(n/10000000), "crore "));
     sb.append(numToString((int)((n/100000) % 100), "lakh "));
     sb.append(numToString((int)((n/1000) % 100), "thousand "));
     sb.append(numToString((int)((n/100) % 100), "hundred "));
     
     if(n>100 && n%100 > 0){
         sb.append("and ");
     }
     sb.append(numToString((int)(n%100), ""));
     return sb.toString();
 }
 
 static String numToString(int n, String s){
    String str = "";
     
     if(n > 19){
         str += tens[n/10] + arr[n%10];
     } else {
         str += arr[n];
     }
     
     if(n != 0){
         str += s;
     }
     return str;
 }
}

