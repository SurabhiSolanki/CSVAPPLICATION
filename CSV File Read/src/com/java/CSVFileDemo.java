package com.java;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVFileDemo {
  public static void readFile(String path) {
	  String data="";
	  int count=0;
	  int cc=0;
	  int co=0;
	 
	  try {
		  BufferedReader br= new BufferedReader(new FileReader(path));
		  while((data=br.readLine())!=null) {
			  String add[]=data.split(",");
			  System.out.println("FirstName="+add[0]+",LastName="+add[1]);
			  count++;
			  if(add[4].contains("NJ")) {
				  cc++;
			  }else if(add[4].contains("SD")) {
				  co++;
			  }
			 
		  }
		 System.out.println("Total No if Records="+count+"  "+cc+" "+co);
	  }catch(Exception ex) {
		  
	  }
  }
  public static void main(String args[]) {
	  CSVFileDemo.readFile("D:\\CRUDWorkspace\\CSV File Read\\addresses.csv");
  }
}
