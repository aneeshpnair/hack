package com.hack;

import java.io.IOException;
import java.util.Scanner;

public class JackDaniel {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int in = 0; in < cases; in++){
			String jLine = sc.next();
			String dLine = sc.next(); 
			System.out.println(extract(jLine.toCharArray(), dLine.toCharArray()));
		}
		sc.close();
	}
	
	private static String extract(char[] j, char [] d){
		int ji = 0;
		int di = 0;
		char [] all = new char[j.length + d.length];
		int ai = 0;
		boolean jChosen = false;
		while(true){
			if(ji < j.length && di < d.length){
				if(j[ji] <= d[di]){
					all[ai] = j[ji];
					ai++;
					ji++;
					jChosen = true;
				}
//				else if(j[ji] == d[di]){
//					if(jChosen){
//						all[ai] = d[di];
//						ai++;
//						di++;
//						jChosen = false;
//					}else{
//						all[ai] = j[ji];
//						ai++;
//						ji++;
//						jChosen = true;
//					}
//				}
				else{
					all[ai] = d[di];
					ai++;
					di++;
					jChosen = false;
				}
			}else if(ji == j.length && di < d.length){
				System.arraycopy(d, di, all, ai, d.length - di);
				jChosen = false;
				break;
			}else if(di == d.length && ji < j.length){
				System.arraycopy(j, ji, all, ai, j.length - ji);
				jChosen = true;
				break;
			}else{
				break;
			}
		}
		return new String(all);
//		
//		
//		
//		
//		
//		char j1 = 0;
//		if(j.length > 0){
//			j1 = j[0];
//		}
//		char d1 = 0;																	
//		if(d.length > 0){
//			d1 = d[0];
//		}
//		
//		if(j1 < d1){
//			if(j.length > 1){
//				char[] j2 = new char[j.length - 1];
//				System.arraycopy(j, 1, j2, 0, j.length - 1);
//				return j1 + extract(j2, d);
//			}else if(j.length == 1){
//				return j1 + extract(new char[0], d);
//			}else{
//				return ;
//			}
//		}else{
//			String d2 = "";
//			if(d.length() > 1){
//				d2 = d.substring(1);
//			}
//			if(d2.length() > 0 || j.length() > 0){
//				return d1 + extract(j, d2);
//			}else{
//				return d1;
//			}
//		}
	}
}
