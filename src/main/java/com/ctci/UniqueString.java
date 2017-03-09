package com.ctci;

public class UniqueString {

	public static void main(String[] args) {
		String str = "dzazbhjsmbek";
		System.out.println(isU(str));
	}

	private static boolean isUnique(String ss){
		boolean [] all = new boolean [256];
		if(ss.length() > 128){
			return false;
		}
		for(int i = 0; i < ss.length(); ++i){
			char c = ss.charAt(i);
			if(all[c]){
				return false;
			}else{
				all[c] = true;
			}
		}
		return true;
	}
	
	private static boolean isU(String ss){
		int checker = 0;
		for(int i = 0; i < ss.length(); ++i){
			int val = ss.charAt(i) - 'a';
			if((checker & (1 << val)) > 0){
				return false;
			}
			checker |= (1<< val);
		}
		return true;
	}
}
