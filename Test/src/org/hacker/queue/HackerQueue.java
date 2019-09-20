package org.hacker.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

public class HackerQueue {
	  private Stack<Character> q=new Stack<>();    
	  private Deque<Character> dq = new ArrayDeque<>();
	  
	  boolean value = true;
	    
	    public boolean pushCharacter(Character c){
	       return q.add(c);
	    }
	    
	    public void enqueueCharacter(Character c){
	    	 dq.push(c);
	    }

		public Character dequeueCharacter() {
			Character val = q.pop();
			System.out.println(val);
			return val;
		}

		public Character popCharacter() {
			Character val = dq.pollLast();
			System.out.println(val);
			return val;
		}
	    
	    
	     

}
