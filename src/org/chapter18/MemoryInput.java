package org.chapter18;

import java.io.StringReader;

public class MemoryInput {

	public static void main(String[] args) throws Exception {
		/*StringReader����һ��String����Ȼ�����*/
		StringReader in = new StringReader(BufferedInputFile.read("./src/org/chapter18/MemoryInput.java"));
		int c;
		while((c = in.read()) != -1) {
			System.out.print((char) c); 
		}
	}
}
/*
 * һ��int����һ���ַ�����������ʱ�򣬸�16λ����Ϊ0
 * ������ַ�����ֻ��Ҫ��8λ����������ģ�����Ҫ16λ
 */