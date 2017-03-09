package com.hack;

import java.io.IOException;
import java.util.Scanner;

public class MatrixRotation {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		int [] [] mx = new int [m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				mx[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		int min = m < n ? m : n;
		int ly = min / 2;
		int [][] rmx = new int [m][n];
		rotate(m, min, mx, rmx, ly, r);
		print(rmx, m, n);
		
//		boolean flip = true;
//		for(int i = 0; i < r; ++i){
//			if(flip){
//				rotate(m, n, mx, rmx, ly);
//				flip = false;
//			}else{
//				rotate(m, n, rmx, mx, ly);
//				flip = true;
//			}
//		}
//		if(flip){
//			print(mx, m, n);
//		}else{
//			print(rmx, m, n);
//		}
	}
	private static void print(int[][] mx, int m, int n){
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.print(mx[i][j]);
				if(j < n - 1){
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	private static void rotate(int m, int n, int[][] mx, int [] [] rmx, int l, int r) {
		for(int ly = 0; ly < l; ly++){
			int m1 = m - 2 * ly;
			int n1 = n - 2 * ly;
			int ringSize = 2 * (n1 + m1) - 4;
			int r1 = r % ringSize;
			for(int i = ly; i < m - ly; i++){
				for(int j = ly; j < n - ly; j++){
					int [] pos = newPosition(m, n, ly, i, j, r1);
					rmx[pos[0]][pos[1]] = mx[i][j];
				}
			}
		}
	}
	private static int [] newPosition(int m, int n, int ly, int i, int j, int r) {
		int [] ret = new int [2];
		ret[0] = i;
		ret[1] = j;
		if(r == 0){
			return ret;
		}
		if(isTop(i, ly)){
			if(isLeft(j, ly)){
				ret[0] = i + 1;
			}else{
				ret[1] = j - 1;
			}
		}
		else if(isLeft(j, ly)){
			if(isBottom(i, ly, m)){
				ret[1] = j + 1;
			}else{
				ret[0] = i + 1;
			}
		}
		else if(isBottom(i, ly, m)){
			if(isRight(j, ly, n)){
				ret[0] = i - 1;
			}else{
				ret[1] = j + 1;
			}
		}
		else if(isRight(j, ly, n)){
			if(isTop(i, ly)){
				ret[1] = j - 1;
			}else{
				ret[0] = i - 1;
			}
		}
		return newPosition(m, n, ly, ret[0], ret[1], r - 1);
	}
	private static boolean isTop(int i, int ly){
		if(i - ly == 0){
			return true;
		}
		return false;
	}
	private static boolean isLeft(int j, int ly){
		if(j - ly == 0){
			return true;
		}
		return false;
	}
	private static boolean isBottom(int i, int ly, int m){
		if(i + ly == m - 1){
			return true;
		}
		return false;
	}
	private static boolean isRight(int j, int ly, int n){
		if(j + ly == n - 1){
			return true;
		}
		return false;
	}
	
}
