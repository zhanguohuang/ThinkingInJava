package org.chapter18;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * DataInputStream必须使用available(有效的)来检测是否到结尾了
 * @author Administrator
 *
 */
public class TestEOF {

	public static void main(String[] args) throws Exception {
		/*BufferedInputStream是缓存流*/
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("./src/org/chapter18/TestEOF.java")));
		while(in.available() != 0)  /*等于0说明后面一句不存在字符了*/
			System.out.println((char)in.readByte());
	}
}
