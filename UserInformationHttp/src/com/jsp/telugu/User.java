package com.jsp.telugu;



public class User {
	TeluguMatrimony teluguMatrimony;
public static void main(String[] args) {
	Docter dott = new Docter();
	//System.out.println(dott);
	System.out.println("Docter details:");
	dott.age();
	dott.name();
	dott.stream();
	System.out.println("-----------------------------------");
	System.out.println("Engineer details");
	Engineer eng = new Engineer();
			eng.age();
	        eng.name();
	        eng.stream();
	        
}
   
}
