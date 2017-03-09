package com.hack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class Student2 {
	private int token;
	private String fname;
	private double cgpa;

	public Student2(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getToken() {
		return token;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}

	@Override
	public String toString() {
		return fname;
	}
	
}

public class PQueue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int totalEvents = Integer.parseInt(in.nextLine());
		PriorityQueue<Student2> pq = new PriorityQueue<Student2>(1000, new Comparator<Student2>() {
			@Override
			public int compare(Student2 o1, Student2 o2) {
				int ret = Double.valueOf(o2.getCgpa()).compareTo(Double.valueOf(o1.getCgpa()));
				if(ret == 0){
					ret = o1.getFname().compareTo(o2.getFname());
				}
				if(ret == 0){
					ret = Integer.valueOf(o2.getToken()).compareTo(Integer.valueOf(o1.getToken()));
				}
				return ret;
			}
			
		});
		while (totalEvents > 0) {
			String event = in.next();
			if(event.equals("ENTER")){
				String name = in.next();
				double cgpa = in.nextDouble();
				int token = in.nextInt();
				
				Student2 st = new Student2(token, name, cgpa);

				pq.add(st);
			}else{
				pq.poll();
			}
			totalEvents--;
		}
		if(pq.isEmpty()){
			System.out.println("EMPTY");
		}
		Student2 p = null;
		while((p = pq.poll()) != null ){
			System.out.println(p.getFname());
		}
		in.close();
	}
}
