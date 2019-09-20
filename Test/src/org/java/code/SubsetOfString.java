package org.java.code;

public class SubsetOfString {
	
	public static void main(String args[]) {
		printSubSet("ABC", 0,"");
	}
	
	static void printSubSet(String s, int index, String currSubStr) {
		if(index == s.length()) {
			System.out.println(currSubStr);
			return;
		}
		printSubSet(s, index+1, currSubStr);
		printSubSet(s, index+1, currSubStr+s.substring(index));
		
	}
}
