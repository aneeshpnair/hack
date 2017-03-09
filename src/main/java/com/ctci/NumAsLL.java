package com.ctci;

public class NumAsLL {

	public static void main(String[] args) {
		String str1 = "321";
		String str2 = "999";
		
		LL<Integer> l1 = makeNumberFromString(str1);
		LL<Integer> l2 = makeNumberFromString(str2);
		
		LL<Integer> l3 = sum(l1, l2, 0);
		System.out.println();
	}
	
	private static LL<Integer> sum(LL<Integer> l1, LL<Integer> l2, int carryOver){
		int add = l1.data + l2.data + carryOver;
		int carry =  add > 9 ? 1 : 0;
		int reminder = add % 10;
		
		LL<Integer> ret = new LL(reminder);
		if(l1.next != null){
			ret.next = sum(l1.next, l2.next, carry);
		}else{
			ret.next = new LL<Integer>(carry);
		}
		return ret;
	}
	private static LL<Integer> makeNumberFromString(String str){
		char[] chars = str.toCharArray();
		LL<Integer> previous = null;
		LL<Integer> first = null;
		for(int i = chars.length - 1; i >= 0; --i){
			LL<Integer> current = new LL<Integer>(Integer.valueOf(String.valueOf(chars[i])));
			if(previous != null){
				previous.next = current;
				current.prev = previous;
			}else{
				first = current;
			}
			previous = current;
		}
		return first;
	}

}
