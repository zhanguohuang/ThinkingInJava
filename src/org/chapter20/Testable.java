package org.chapter20;



public class Testable {
	public void execute(){
		System.out.println("Executing..");
	}
	//注解的位置几乎和public等关键字的位置一样
	@Test void testExecute(){
		execute();
	}
}
