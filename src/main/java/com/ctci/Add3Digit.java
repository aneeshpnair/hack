package com.ctci;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Add3Digit {

	public static void main(String[] args) {
		List<Integer> ns = new ArrayList<Integer>();
		for(int i = 100; i < 999; ++i){
			if(getDistinct(i).size() == 3)
				ns.add(i);
		}
		System.out.println(ns.size());
		for(int i : ns){
			for(int j : ns){
				Set<Integer> ss = new HashSet<Integer>();
				ss.addAll(getDistinct(i));
				ss.addAll(getDistinct(j));
				int k = i + j;
				ss.addAll(getDistinct(k));
				
				if(ss.size() == 10){
					System.out.println(i + " + " + j + " = " + k);
				}
			}
		}
	}
	private static Set<Integer> getDistinct(int n){
		Set<Integer> ss = new HashSet<Integer>();
		int d3 = n % 10;
		ss.add(d3);
		int rem = n / 10;
		int d2 = rem % 10;
		ss.add(d2);
		rem = rem / 10;
		int d1 = rem % 10;
		ss.add(d1);
		if(rem > 9){
			rem = rem / 10;
			int d0 = rem % 10;
			ss.add(d0);
		}
		return ss;
	}
	
}
