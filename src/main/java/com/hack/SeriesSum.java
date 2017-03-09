package com.hack;

import java.io.IOException;
import java.util.Scanner;

public class SeriesSum {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; ++i){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			for(int j = 1; j <= n; ++j){
				int sum = a;
				for(int x = 0; x < j; ++x){
					sum += Math.pow(2, x) * b;
				}
				if(j > 1)
					System.out.print(" ");
				System.out.print(sum);
			}
			System.out.println();
		}

		
	}
}
