package org.learn.multithreading;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		
		ThreadGroup g = new ThreadGroup("Group");
		ThreadGroup sg = new ThreadGroup(g, "SubGroup");
		System.out.println("Parent group of g is "+g.getParent().getName());
		System.out.println("Parent group of sg is "+sg.getParent().getName());
	}

}
