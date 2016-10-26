package org.chapter18;

import java.io.StringReader;

public class MemoryInput {

	public static void main(String[] args) throws Exception {
		/*StringReader接受一个String对象然后输出*/
		StringReader in = new StringReader(BufferedInputFile.read("./src/org/chapter18/MemoryInput.java"));
		int c;
		while((c = in.read()) != -1) {
			System.out.print((char) c); 
		}
	}
}
/*
 * 一个int等于一个字符，读进来的时候，高16位基本为0
 * 如果是字符，则只需要低8位，如果是中文，则需要16位
 */