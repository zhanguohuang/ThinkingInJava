package org.chapter8;

public class Constructor {
	private String s = new PrintDemo().print();
	static{
		new PrintDemo();
	}
	
	public static void main(String[] args) {
		new Constructor();
	}
	
	
}
class PrintDemo{
	PrintDemo(){
		System.out.println("PrintDemo constructor");
	}
	String print(){
		System.out.println("print");
		return "print";
	}
}
