package com.ctci;

public class RearrangeLL {

	public static void main(String[] args) {
		String str1 = "123456789";
	
		LLN ln = LLN.makeNumberFromString(str1);
		//System.out.println(ln);
		
		LLN curRev = ln;
		LLN curFor = ln;
		boolean foundLast = false;
		int fi = 0;
		int ri = 0;
		while(true){

			if(foundLast){
				curRev.next = curFor.next;
				curFor.next.prev = curRev;
				
				curRev = (LLN) curRev.prev;
				curRev.next = null;
				ri--;
				
				curFor.next = curFor.next.prev;

				curFor = (LLN) curFor.next.next;
				fi++;
				
				if(fi >= ri){
					break;
				}
			}else{
				if(curRev.next == null){
					foundLast = true;
				}else{
					curRev = (LLN) curRev.next;
					ri ++;
				}
			}
		}
		System.out.println(ln);
	}
	


}
