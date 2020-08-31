package com.java;

import java.util.HashMap;

public class SequenceSepratedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Nos="10,8,9,-2,4,0,-1,12";
		String data="";
		String result[]=Nos.split(",");
		
		
		
		int [] arr = new int[result.length];
		int arr1[]=new int[result.length];
		for(int i=0;i<result.length;i++) {
			//System.out.println(result[i]);
			arr[i]=Integer.parseInt(result[i].toString());
			if(arr[i]%2==0) {
				arr1[i]=arr[i];
			}
			//System.out.print(" "+arr1[i]);
		}
		
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>(); 
		 for (int i = 0; i < arr1.length; i++) { 
	            hm.put(arr1[i], i); 
	           
	        } 
		
		
		System.out.print(hm.keySet());
	}

}
