package com.jsp.telugu;

public class Engineer implements TeluguMatrimony {

	@Override
	public String name() {
		System.out.println("surya");
		return null ;
	}

	@Override
	public int age() {
		System.out.println("25");
		return 0;
	}

	@Override
	public String stream() {
		System.out.println("MCA");
		return null;
	}

}
