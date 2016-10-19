package org.chapter15;

class Automobile {}

/**
 * 只能持有单一的对象
 * @author Administrator
 *
 */
public class Holder1 {
	
	private Automobile a;
	
	public Holder1(Automobile a) {
		this.a = a;
	}
	
	Automobile get() {
		return a;
	}
}
