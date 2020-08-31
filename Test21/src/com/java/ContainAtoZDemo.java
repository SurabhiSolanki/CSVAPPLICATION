package com.java;

public class ContainAtoZDemo {
	 public static String checkString(String input) {
	        int index = 0;
	        boolean[] visited = new boolean[26];
	 
	        for (int id = 0; id < input.length(); id++) {
	            if ('a' <= input.charAt(id) && input.charAt(id) <= 'z') {
	                index = input.charAt(id) - 'a';
	            } else if ('A' <= input.charAt(id) && input.charAt(id) <= 'Z') {
	                index = input.charAt(id) - 'A';
	            }
	            visited[index] = true;
	        }
	 
	        for (int id = 0; id < 26; id++) {
	            if (!visited[id]) {
	                return "not complete";
	            }
	        }
	        return "complete";
	    }
	 
	   public static void main(String args[]) {
		   String str1 = "abcdefghijklmnopqrstuvwxyz";
	       System.out.println(checkString(str1));
	  
	       String str2 = "ABCDEFGHIJKLMNOP";
	       System.out.println(checkString(str2));
	       
	   }

}
