package org.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 用BufferedReader缓存的方式快速读取文件
 * @author Administrator
 *
 */
public class BufferedInputFile {

	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null) 
			sb.append(s + "\n");
		in.close();
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(read("./src/org/chapter18/BufferedInputFile.java"));
	}
}
