package org.chapter10;

interface ClassInInterface{
	void howdy();
	class Test implements ClassInInterface{
		public void howdy(){
			System.out.println("howdy");
		}
	}
}

class C{
	public static void main(String[] args) {
		ClassInInterface ci = 
				new ClassInInterface.Test.Test.Test.Test.Test();
		ci.howdy();
	}
}