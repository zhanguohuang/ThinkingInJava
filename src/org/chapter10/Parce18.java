package org.chapter10;

public class Parce18 {
	public Wrapping wrapping(int x){
		return new Wrapping(x){
			public int value(){
				return super.value() * 47;
			}
		};
	}
	public static void main(String[] args) {
		Parce18 p = new Parce18();
		Wrapping w = p.wrapping(10);
		//System.out.println(w.value());
	}
}

class Wrapping{
	private int i;
	public Wrapping(int x){
		i = x;
	}
	public int value(){
		return i;
	}
}
