package com.hack;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class SherlockString {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < str.length(); ++i){
			String ch = String.valueOf(str.charAt(i));
			
			Integer count = map.get(ch);
			if(count != null){
				map.put(ch, count+1);
			}else{
				map.put(ch, 1);
			}
		}
		System.out.println(map);
		
		Map<Integer, StringBuffer> nMap = new HashMap<Integer, StringBuffer>();
		for(Entry<String, Integer> e : map.entrySet()){
			StringBuffer sb = nMap.get(e.getValue());
			if(sb != null){
				sb.append(e.getKey());
				nMap.put(e.getValue(), sb);
			}else{
				nMap.put(e.getValue(), new StringBuffer(e.getKey()));
			}
		}
		if(nMap.size() > 2){
			System.out.println("NO");
		}else{
			if(nMap.size() == 2){
				boolean yes = false;
				for(Entry<Integer, StringBuffer> e : nMap.entrySet()){
					if(e.getKey() <= 2 && e.getValue().length() == 1){
						yes = true;
					}
				}
				if(yes){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}else{
				System.out.println("YES");
			}
		}
	}
}
