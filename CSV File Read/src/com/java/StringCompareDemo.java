package com.java;

public class StringCompareDemo {

	public static boolean compare(String s1,String s2) {
	   boolean flag=false;
	   int k=0;
	   if(s1.length()==s2.length()) {
		   k=1;
	   }
	   for (int i=0;i<s1.length();i++) {
		   if(s1.charAt(i)==s2.charAt(i)) {
			   flag=true;
			   break;
		   }
	   }
	   if(flag==true) {
		   return flag;
	   }
	   return flag;
	}
	
	public static void main(String[]ar) {
		System.out.println(compare("Solanki", "Surabhi"));
	}
}
