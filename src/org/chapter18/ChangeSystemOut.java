package org.chapter18;

import java.io.PrintWriter;

public class ChangeSystemOut {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);  /*true自动刷新，必须为true*/
		out.println("Hello, world");
	}
}
