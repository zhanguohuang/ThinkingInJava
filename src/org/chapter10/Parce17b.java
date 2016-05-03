package org.chapter10;


public class Parce17b {
	class MyContents implements Contents{
		private int i = 11;
		public int value(){
			return i;
		}
	}
	public Contents contents(){
		return new MyContents();
	}
	public static void main(String[] args) {
		Parce17b p = new Parce17b();
		Contents c = p.contents();
		System.out.println(c.value());
	}
}

interface Contents{
	int value();
}
