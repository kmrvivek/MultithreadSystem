package org.ds_queue.com;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayQueue {

	private Employee[] queue;
	private int front;
	private int back;
	
	public ArrayQueue(int capacity) {
		queue = new Employee[capacity];
	}
	
	public void add(Employee employee) {
		if(back == queue.length) {
			// need to resize the backing array
			
			Employee[] newArray = new Employee[2 * queue.length];
			System.arraycopy(queue, 0, newArray, 0, queue.length);
			queue = newArray;
		}
		
		queue[back++] = employee;
	}
	
	public Employee remove() {
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		
		Employee employee = queue[front];
		queue[front++] = null;
		
		if(size() == 0) {
			front = 0;
			back = 0;
		}
		return employee;
	}
	
	public int size() {
		return back - front;
	}
	
	public Employee peek() {
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		
		Employee employee = queue[front];
		return employee;
	}
	
		
	public void printQueue() {
		for(int i = front; i < back; i++) {
			System.out.println(queue[i]);
		}
		
	}
	
	public boolean isEmpty() {
		return back == 0;
	}
}
