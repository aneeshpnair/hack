package com.hack;

import java.io.*;
import java.util.*;

interface PerformOperation {
	boolean check(int a);
}

class MyMath {
	public PerformOperation is_odd = (int a) -> {
		if(a % 2 != 0){
			return true;
		}
		return false;
	};
	
	public PerformOperation is_prime = (int a) -> {
		for(int i = 0 ; i < a/2; i++){
			if(a % i == 0){
				return false;
			}
		}
		return true;
	};
	
	public PerformOperation is_palindrome = (int a) -> {
		String str = String.valueOf(a);
		StringBuffer sb = new StringBuffer(str);
		String r = sb.reverse().toString();
		if(str.equals(r)){
			return true;
		}
		return false;
	};
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}
	public PerformOperation is_odd(){
		return is_odd;
	}
	public PerformOperation is_prime(){
		return is_prime;
	}
	public PerformOperation is_palindrome(){
		return is_palindrome;
	}
}

public class Lambda {

	public static void main(String[] args) throws IOException {
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.is_odd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.is_prime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.is_palindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	}
}
