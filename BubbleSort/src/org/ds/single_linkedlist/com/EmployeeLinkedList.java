package org.ds.single_linkedlist.com;

public class EmployeeLinkedList {

	private EmployeeNode head;
	private int size;
	
	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		this.head = node;
		size++;
	}
	
	public EmployeeNode removeFromFront() {
		if(isEmpty()) {
			return null;
		} else {
			
			EmployeeNode removedNode = head;
			head = head.getNext();
			removedNode.setNext(null);
			size--;
			return removedNode;
		}
		
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
			System.out.print(" -> ");
			current = current.getNext();
			
		}
		System.out.println("null");
	}
}
