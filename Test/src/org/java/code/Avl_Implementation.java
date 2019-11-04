package org.java.code;

import java.util.Arrays;

public class Avl_Implementation {

	public static void main(String[] args) {
		
		int arr[] = {87, 49, 20, 72, 41, 4, 52, 76, 100};
		//int[] arr = {10, 6, 9, 7, 20, 19, 21, 18, 17, 16};
		TreeUtil tl = new TreeUtil();
		tl.countSmallerOnRight(arr);
	}

}

class Node {
	int key;
	int height;
	int size;
	Node left;
	Node right;

	public Node(final int key) {
		this.key = key;
		this.height = 1;
		this.size = 1;
		this.left = null;
		this.right = null;
	}
	
}

class TreeUtil {
	static int small =0;
	 private int max(int a, int b) { 
	        return (a > b) ? a : b; 
	   } 
	
	Node insertAvl(Node root, int val, int[] smaller, int i) {
		if(root == null) {
			return new Node(val);
		}
		
		if(root.key > val) {
			root.left = insertAvl(root.left, val, smaller, i);
		} else if(root.key < val) {
			root.right =  insertAvl(root.right, val, smaller, i);	
			smaller[i] = smaller[i] + size(root.left) + 1;
			if(small < smaller[i]) {
				small = smaller[i];
			}
		}  else {
            return root; 
		}
		root.height = max(height(root.left), height(root.right)) + 1;
		 root.size = max(size(root.left), size(root.right)) + 1;
		
		int balance =  height(root.left) - height(root.right);
		
		if(balance > 1 && val < root.left.key) {
			return rotateRight(root);
		}
		
		if(balance < -1 && val > root.right.key) {
			return rotateLeft(root);
		}
		
		if(balance > 1 && val > root.left.key) {
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}
		
		if(balance < -1 && val < root.right.key) {
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}
		
		return root;
	}

	private Node rotateLeft(Node x) {
		Node y = x.right;
		Node t2 = y.left;
		
		y.left = x;
		x.right = t2;
		
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height =  max(height(y.left) , height(y.right)) + 1;
		
		x.size = max(size(x.left), size(x.right)) + 1;
		y.size = max(size(y.left), size(y.right)) + 1;
				
		return y;
	}

	private int size(Node root) {
		return root == null ? 0 : root.size;
	}

	private Node rotateRight(Node x) {
		Node y = x.left;
		Node t2 = y.right;
		
		y.right = x;
		x.left = t2;
		
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		
		x.size = max(size(x.left), size(x.right)) + 1;
		y.size = max(size(y.left), size(y.right)) + 1;
		
		return y;
	}

	private int height(Node root) {
		return root == null ? 0 : root.height;
	}
	
	void printInorder(Node root) {
		if(root == null) {
			return;
		}
		
		printInorder(root.left);
		System.out.print(root.key+" ");
		printInorder(root.right);
		
	}
	
	public void countSmallerOnRight(final int[] in) {
		int[] smaller = new int[in.length];
		Node root = null;
		for (int i = in.length - 1; i >= 0; i--) {
			root = insertAvl(root, in[i], smaller, i);
		}
		
		printInorder(root);
		System.out.println();
		System.out.println(Arrays.toString(smaller));
		
		System.out.println(small);
		
	}
}
