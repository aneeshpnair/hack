package com.hack;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

class Student1 {

}


public class Student{
	 public static void main(String[] args){
         Class student = Student1.class;
         Method[] methods = student.getMethods();

         ArrayList<String> methodList = new ArrayList<>();
         for(Method m : methods){
             methodList.add(m.getName());
         }
         Collections.sort(methodList);
         for(String name: methodList){
             System.out.println(name);
         }
     }
}