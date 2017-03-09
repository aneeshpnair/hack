package com.hack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringToTree {

	public static void main(String[] args) {
        String ss = "1[2[4,5],3[6]]";
        StringBuffer sb = new StringBuffer();
        Stack<Node> parents = new Stack<Node>();
        char prevDelim = 0;
        Node root = null;
        for(int i = 0; i < ss.length(); ++i){
        	char c = ss.charAt(i);
        	if(c == '[' || c == ']' || c == ','){
        		if(sb.length() > 0){
        			Node n = new Node(sb.toString());
        			if(parents.isEmpty()){
        				root = n;
        				//parents.push(n);
        			}
        			
        			if(c == '['){
        				Node parent = parents.isEmpty() ? null : parents.peek();
        				if(parent != null)
        					parent.nodes.add(n);
        				parents.push(n);
    				}
        			else if(c == ']'){
        				Node parent = parents.peek();
        				parent.nodes.add(n);
        				parents.pop();
    				}else if(c == ','){
        				Node parent = parents.peek();
        				parent.nodes.add(n);
        			}
        			
            		System.out.println(n);
        		}
        		sb.setLength(0);
        		prevDelim = c;
        	}else{
        		sb.append(c);
        	}
        }
        System.out.println(root);
    }

}
