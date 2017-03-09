package com.hack;

public class BNode {
	BNode left;
	BNode right;
	int data;
	public BNode(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return String.valueOf(data);
	}
	
}
