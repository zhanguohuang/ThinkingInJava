package org.chapter18;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * DataInputStream����ʹ��available(��Ч��)������Ƿ񵽽�β��
 * @author Administrator
 *
 */
public class TestEOF {

	public static void main(String[] args) throws Exception {
		/*BufferedInputStream�ǻ�����*/
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("./src/org/chapter18/TestEOF.java")));
		while(in.available() != 0)  /*����0˵������һ�䲻�����ַ���*/
			System.out.println((char)in.readByte());
	}
}
