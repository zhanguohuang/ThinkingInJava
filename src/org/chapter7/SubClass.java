package org.chapter7;

class FinalDemo {
	private final void func(){
		System.out.println("FinalDemo-->func()");
	}
}

public class SubClass extends FinalDemo{
	SubClass(){};
	final void func(){
		System.out.println("SubClass-->func()");
	}
	public static void main(String[] args) {
		new SubClass().func();
	}
}
