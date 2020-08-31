package com.java;

import java.util.HashMap; 
public class IntegerDistinctDemo {
	
	
	    public static void main(String args[]) 
	  
	    { 
	        int ar[] = { 9,4,8,9,0,2,4,7 }; 
	        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>(); 
	        for (int i = 0; i < ar.length; i++) { 
	            hm.put(ar[i], i); 
	        } 
	       
	        System.out.println(hm.keySet()); 
	  
	    } 
	  
	
}
