package com.hack;

import java.util.ArrayList;
import java.util.List;

public class Node{
	List<Node> nodes = new ArrayList<Node>();
	String data;
	public Node(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return data;
	}
	
}