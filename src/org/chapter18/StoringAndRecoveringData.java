package org.chapter18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * DataInputStream和DataOutputStream的平台无关性
 * 使得他们可以避免编码的问题很好的恢复数据
 * @author Administrator
 *
 */
public class StoringAndRecoveringData {

	public static void main(String[] args) throws Exception {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("./src/org/chapter18/StoringAndRecoveringData.data")));
		out.writeDouble(3.14159);
		out.writeUTF("That was pi");
		out.writeDouble(1.1414);
		out.writeUTF("Square root of 2");
		out.close();
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("./src/org/chapter18/StoringAndRecoveringData.data")));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
	}
}
/*
3.14159
That was pi
1.1414
Square root of 2
*/