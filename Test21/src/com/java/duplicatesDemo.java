package com.java;
import java.util.*; 
public class duplicatesDemo {

	  
	   
	    static void removeDuplicates(char[] str)  
	    { 
	        int n = str.length; 
	  
	       
	        if (n < 2)  
	        { 
	            return; 
	        } 
	  
	      
	        int j = 0; 
	  
	      
	        for (int i = 1; i < n; i++)  
	        { 
	          
	            if (str[j] != str[i]) 
	            { 
	                j++; 
	                str[j] = str[i]; 
	            } 
	        } 
	        System.out.println(Arrays.copyOfRange(str, 0, j + 1)); 
	    } 
	  
	    // Driver code 
	    public static void main(String[] args) 
	    { 
	        char str1[] = "Ratannnna".toCharArray(); 
	        removeDuplicates(str1); 
	  
	        char str2[] = "aabcca".toCharArray(); 
	        removeDuplicates(str2); 
	    } 
	} 

