package com.hack;

import java.io.*;
import java.util.*;

public class FunGame {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		sc.nextLine();
		for(int in = 0; in < cases; in++){
			String nLine = sc.nextLine(); 
			int n = Integer.parseInt(nLine);
			//System.out.println(n);
			
			String aLine = sc.nextLine();
			Scanner asc = new Scanner(aLine);
			List<Integer> a = new ArrayList<>();
			while(asc.hasNextInt()){
				a.add(asc.nextInt());
			}
			asc.close();
			//System.out.println(a);
			
			String bLine = sc.nextLine();
			Scanner bsc = new Scanner(bLine);
			List<Integer> b = new ArrayList<>();
			while(bsc.hasNext()){
				b.add(bsc.nextInt());
			}
			bsc.close();
			//System.out.println(b);
			//if(a.size() == n && b.size() == n){
			List<Values> c = new ArrayList<Values>();
			List<Values> d = new ArrayList<Values>();
			for(int i = 0; i < a.size(); i++){
				int aNum = a.get(i);
				int bNum = 0;
				if(b.size() > i){
					bNum = b.get(i);
				}
				c.add(new Values(aNum, aNum + bNum));
			}
			for(int i = 0; i < b.size(); i++){
				int bNum = b.get(i);
				int aNum = 0;
				if(a.size() > i){
					aNum = a.get(i);
				}
				d.add(new Values(bNum, bNum + aNum));
			}
			Collections.sort(c);
			Collections.sort(d);
			//System.out.println(b);
			
			int cTotal = 0;
			int dTotal = 0;
			boolean p1 = true;
			for(int i = 0; i < n; ++i){
				if(p1){
					cTotal += c.get(i).getOriginal();
					p1 = false;
				}else{
					dTotal += d.get(i).getOriginal();
					p1 = true;
				}
			}
			//System.out.println(aTotal + "--" + bTotal);
			if(cTotal > dTotal){
				System.out.println("First");
			}else if(cTotal == dTotal){
				System.out.println("Tie");
			}else{
				System.out.println("Second");
			}
		}
		sc.close();
	}
}
class Values implements Comparable<Values>{
	int original;
	public Values(int original, int sum) {
		super();
		this.original = original;
		this.sum = sum;
	}
	int sum;
	public int getOriginal() {
		return original;
	}
	public void setOriginal(int original) {
		this.original = original;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public int compareTo(Values o) {
		return o.getSum() - sum;
	}
}