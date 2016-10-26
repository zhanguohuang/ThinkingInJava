package org.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {

	static String file = "./src/org/chapter18/BasicFileOutput.java";
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(file)));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./src/org/chapter18/BasicFileOutput.out")));
		int lineCount = 1;
		String s;
		while((s = in.readLine()) != null) {
			out.println(lineCount++ + ": " + s);/*写入行号和当前行的字符串*/
		}
		out.close();
		System.out.println(BufferedInputFile.read("./src/org/chapter18/BasicFileOutput.out"));
	}
}
