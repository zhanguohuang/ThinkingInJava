package org.chapter20;



public class Testable {
	public void execute(){
		System.out.println("Executing..");
	}
	//ע���λ�ü�����public�ȹؼ��ֵ�λ��һ��
	@Test void testExecute(){
		execute();
	}
}
