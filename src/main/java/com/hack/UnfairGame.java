package com.hack;

import java.util.Scanner;

public class UnfairGame {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int test;
		test = in.nextInt();
		for (int t = 0; t < test; t++) {
			int N;
			N = in.nextInt();

			int v[] = new int[N];
			int xor = 0;
			for (int i = 0; i < N; i++) {
				v[i] = in.nextInt();
				if(i != 0){
					if(i == 1){
						xor = v[i] ^ v[i-1];
					}else{
						xor = xor ^ v[i];
					}
				}
			}

			int result = 0;
			System.out.println(xor);
		}
	}

}


//int x[] = {1, 1, 1};
//int xor = 0;
//for(int i = 0; i < x.length; i++){
//	if(i != 0){
//		if(i == 1){
//			xor = x[i] ^ x[i-1];
//		}else{
//			xor = xor ^ x[i];
//		}
//	}
//}
//System.out.println(xor);