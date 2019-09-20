package org.hacker.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class TreeTopView {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t > 0) {
			HashMap<Integer, Node> m = new HashMap<>();
			int n = sc.nextInt();
			Node root = null;
			while(n > 0) {
				int n1= sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				Node parent = m.get(n1);
				if(parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if(root == null) {
						root = parent;
					}
					Node child = new Node(n2);
					if(lr == 'L') 
						parent.left = child;
					else	
						parent.right = child;
					m.put(n2, child);
					n--;
					}
				new View().topView(root);
				System.out.println();
				t--;
				}
			}
		}
	}
	


class Node{
	int data; 
	Node left, right;
	Node(int item){
		this.data = item;
		left =right = null;
	}
}


class View
{
    // function should print the topView of the binary tree
    static Queue<Node> s ;
    static Map<Integer, ArrayList<Integer>> mapval; 
    static void topView(Node root)
    {   
        s = new LinkedList<Node>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            s.add(temp);
            if(temp.left != null){
                q.add(temp.left);
            }
            
            if(temp.right != null){
                q.add(temp.right);
            }
            
        }
        mapval = new HashMap<>();
        treeTraversal(root, 0);
       for(Node item : s){
            System.out.print(item.data+" ");
        }
        System.out.println();
         for (Map.Entry<Integer, ArrayList<Integer>> entry : mapval.entrySet()) { 
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); 
         } 
        StringBuffer sb = new StringBuffer();
       
         for(Map.Entry<Integer, ArrayList<Integer>> entry : mapval.entrySet()){
             if(entry.getValue().size() == 1){
                 if(entry.getKey() > 0){
                     sb.append(entry.getValue().get(0)+" ");
                 }else {
                      sb.insert(0,entry.getValue().get(0)+" ");
                 }
             } else {
                 Queue<Node> temp = s;
                 boolean check = true;
                 while(check && !temp.isEmpty()){
                     Node tre = temp.poll();
                     int val = tre.data;
                     System.out.println(entry.getValue());
                    if(entry.getValue().contains(val)){
                          if(entry.getKey() > 0){
                     sb.append(val+" ");
                        }else {
                      sb.insert(0,val+" ");
                        }
                         check = false;
                     }
                 }
                 
             }
         }    
         
         System.out.print(sb);
         
    }
    
    static void treeTraversal(Node root, int val){
        if(root == null){
            return;
        }
        if(mapval.containsKey(val)){
            ArrayList<Integer> ar = mapval.get(val);
            ar.add(root.data);
        } else {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(root.data);
            mapval.put(val, arr);
        }
        treeTraversal(root.left, val-1);
        treeTraversal(root.right, val+1);
    }
}
