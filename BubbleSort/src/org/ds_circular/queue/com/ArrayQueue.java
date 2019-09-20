package org.ds_circular.queue.com;

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
		if(size() == queue.length - 1) {
			// need to resize the backing array
			int numItems = size();
			Employee[] newArray = new Employee[2 * queue.length];
			System.arraycopy(queue, front, newArray, 0, queue.length - front);
			System.arraycopy(queue, 0, newArray, queue.length - front, back);
			
			queue = newArray;
			
			front = 0;
			back = numItems;
		}
		
		queue[back] = employee;
		if(back < queue.length -1) {
			back++ ;
		} else {
			back = 0;
		}
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
		} else if(front == queue.length) {
			front = 0;
		}
		return employee;
	}
	
	public int size() {
		if(front <= back) {
			return back - front;
		} else {
			return back - front + queue.length;
		}
		
	}
	
	public Employee peek() {
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		
		Employee employee = queue[front];
		return employee;
	}
	
		
	public void printQueue() {		
		if(front <= back) {
			for(int i = front; i < back; i++) {
				System.out.println(queue[i]);
			}
		} else {
			for(int i = front; i < queue.length; i++) {
				System.out.println(queue[i]);
			}
			for(int i = 0; i < back; i++) {
				System.out.println(queue[i]);
			}
		}
		
		
	}
	
	public boolean isEmpty() {
		return back == 0;
	}
}
