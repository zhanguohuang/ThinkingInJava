package org.chapter15;

/**
 * 使用了参数化类型T，比Object更好
 * @author Administrator
 *
 * @param <T>
 */
public class Holder3<T> {

	private T a;
	
	public Holder3(T a) {
		this.a = a;
	}
	
	public void set(T a) {
		this.a = a;
	}
	
	public T get() {
		return a;
	}
	
	public static void main(String[] args) {
		Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
		Automobile a = h3.get();
		// h3.set("Not an Automobile");
	}
}
