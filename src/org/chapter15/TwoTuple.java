package org.chapter15;

public class TwoTuple<A, B> {

	/*final能为字段提供同样的安全性*/
	public final A first;
	public final B second;
	
	/**
	 * 必须含有此方法来初始化A和B
	 * @param a
	 * @param b
	 */
	public TwoTuple(A a, B b) {
		first = a;
		second = b;
	}
	
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}
