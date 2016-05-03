package org.chapter8;

public class SubClass extends FieldDemo {
	public int i = 1;
	public int getField(){
		return i;
	}
	public static void main(String[] args) {
		FieldDemo fd = new SubClass();
		SubClass sc = new SubClass();
		System.out.println(sc.i);
		System.out.println(fd.i);
		System.out.println(fd.getField());
	}
}

class FieldDemo {
	public int i = 0;
	public int getField(){
		return i;
	}
}

