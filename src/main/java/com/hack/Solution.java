package com.hack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
       BNode one = new BNode(1);
       BNode two = new BNode(2);
       BNode three = new BNode(3);
       BNode four = new BNode(4);
       BNode five = new BNode(5);
       three.left = two;
       three.right = four;
       two.left = one;
       four.right = five;
       
       List<LinkedList<BNode>> ll = new ArrayList<LinkedList<BNode>>();
       makeLL(ll, three, 0);
       System.out.println(ll);
    }
	
	private static void makeLL(List<LinkedList<BNode>> ll, BNode node, int level){
		LinkedList<BNode> list = null;
		try{
			list = ll.get(level);
		}catch(Exception e){
			
		}
		finally{
			if(list == null){
				list = new LinkedList<BNode>();
				ll.add(level, list);
			}
		}
		list.add(node);
		if(node.left != null)
			makeLL(ll, node.left, level + 1);
		
		if(node.right != null)
			makeLL(ll, node.right, level + 1);
	}

}
