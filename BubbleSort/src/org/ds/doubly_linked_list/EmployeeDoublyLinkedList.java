package org.ds.doubly_linked_list;

public class EmployeeDoublyLinkedList {

	private EmployeeNode head;
	private EmployeeNode tail;
	private int size;
	
	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
			
		if(head == null) {
			tail = node;
		} else {
			head.setPrevious(node);
			node.setNext(head);
		}
		this.head = node;
		size++;
	}
	
	public void addToTail(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		if(tail ==null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
		}
		
		this.tail = node;
		size++;
	}
	
	public boolean addBeforeEmployee(Employee existingEmployee, Employee newEmployee) {
		if(isEmpty()) {
			System.out.println("Employee list is empty");
			return false;
		} else {
			EmployeeNode current = head;
			System.out.println(head);
			while(current != null && !current.getEmployee().equals(existingEmployee)) {
					current = current.getNext();
				}	
			
			if(current == null) {
				System.out.println(existingEmployee+"----\tNot Found");
				return false;
			}
			
			EmployeeNode newNode = new EmployeeNode(newEmployee);
			newNode.setPrevious(current.getPrevious());
			newNode.setNext(current);
			current.setPrevious(newNode);			
			
			if (head == current) {
	            head = newNode;
	        }
	        else {
	        	newNode.getPrevious().setNext(newNode);
	        }

	        size++;

	        return true;

		}
					
	}
	

	public EmployeeNode removeFromFront() {
		if(isEmpty()) {
			return null;
		} 		
		
		EmployeeNode removedNode = head;
		
		if(head.getNext() == null) {
			tail = null;
		} else {
			head.getNext().setPrevious(null);
		}
			head = head.getNext();
			removedNode.setNext(null);
			size--;
			return removedNode;
	
	}
	
	public EmployeeNode removeFromEnd() {
		if(isEmpty()) {
			return null;
		} 		
		
		EmployeeNode removedNode = tail;
		
		if(tail.getPrevious() == null) {
			head = null;
		} else {
			tail.getPrevious().setNext(null);
		}
			tail = tail.getPrevious();
			removedNode.setNext(null);
			size--;
			return removedNode;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void printList() {
		EmployeeNode current = head;
		System.out.print("HEAD -> ");
		while(current != null) {
			System.out.print(current);
			System.out.print(" <==> ");
			current = current.getNext();
			
		}
		System.out.println("null");
	}
}
