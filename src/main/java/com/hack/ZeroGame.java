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

public class ZeroGame{

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; ++i){
        	int n = in.nextInt();
        	int m = in.nextInt();
        	
        	int [] a = new int [n];
        	
        	BitSet bs = new BitSet();
        	for(int j = 0; j < n; j++){
        		a[j] = in.nextInt();
        	}
        	
        	for(int k = n - 1; k >= 0; k--){
        		if(a[k] == 0 
        				&& (
        					k + 1 > n-1 
        					|| k + m > n - 1
        					|| bs.get(k + 1)
        					|| bs.get(k + m)
        					)
        				){
        			bs.set(k);
        		}else if(k > 0 
        				&& a[k] == 0
        				&& a[k - 1] == 0 
        				&& (     k - 1 + m > n - 1
            					|| bs.get(k - 1 + m)
            					)
            				){
        			bs.set(k);
        		}
        	}
        	if(bs.get(0)){
        		 System.out.println("YES");
        	}else{
        		System.out.println("NO");
        	}
        }
        in.close();
    }

}
