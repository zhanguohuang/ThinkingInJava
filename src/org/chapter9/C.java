package org.chapter9;

interface I1 {
	void fun();
	
}
interface I2{
	void fun();
}
interface I3 extends I1,I2{
	void fun();
}
public class C implements I3{

	@Override
	public void fun() {
		// TODO Auto-generated method stub
		System.out.println("anything is ok");
	}
	public static void main(String[] args) {
		I1 i1 = new C();
		I2 i2 = new C();
		I3 i3 = new C();
		i1.fun();
		i2.fun();
		i3.fun();
	}

}
