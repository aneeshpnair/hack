package com.ctci;

public class LLN extends LL<Integer>{

	public LLN(Integer data) {
		super(data);
	}

	public static LLN makeNumberFromString(String str){
		char[] chars = str.toCharArray();
		LLN previous = null;
		LLN first = null;
		for(int i = 0; i < chars.length; ++i){
			LLN current = new LLN(Integer.valueOf(String.valueOf(chars[i])));
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