package com.ctci;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceSameLevelNodesInBT {
	static BT root;
	static{
		BT six = new BT(6);
		BT five = new BT(5);
		BT four = new BT(4);
		BT seven = new BT(7);
		BT three = new BT(3);
		BT two = new BT(2);
		BT one = new BT(1);
		BT eight = new BT(8);
		BT nine = new BT(9);
		BT ten = new BT(10);
		BT eleven = new BT(11);
		
		six.left = four;
		six.right = seven;
		
		seven.left = ten;
		seven.right = eleven;
		
		four.left = three;
		four.right = two;
		
		three.left = one;
		three.right = five;
		
		two.left = nine;
		two.right = eight;
		
		root = six;
		
	}
	public static void main(String [] args){
		bfs(root, 1, 2);
	}
	static void bfs(BT root, int d1, int d2){
		boolean f1;
		boolean f2;
		
		Queue<BT> q = new LinkedList<BT>();
		root.v = true;
		q.add(root);
		System.out.println(root);
		while(!q.isEmpty()){
			BT n = q.poll();
			if(n != null){
				BT l = n.left;
				if(l != null && !l.v){
					l.v = true;
					q.add(l);
					
					System.out.println(l);
				}
				
				BT r = n.right;
				if(r != null && !r.v){
					r.v = true;
					q.add(r);
					
					System.out.println(r);
				}
			}
		}
	}
}

class BT {
	BT left;
	BT right;
	int data;
	boolean v = false;
	public BT(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "BT [data=" + data + ", v=" + v + "]";
	}
	
}

