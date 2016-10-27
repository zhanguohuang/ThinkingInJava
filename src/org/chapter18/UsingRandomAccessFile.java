package org.chapter18;

import java.io.RandomAccessFile;

/**
 * RandomAccessFile 效果类似于DataInputStream和DataOutputStream
 * 因为他同时继承了DataInput和DataOutput
 * seek()是跳过多少个字节的方法
 * @author Administrator
 *
 */
public class UsingRandomAccessFile {

	static String file = "./src/org/chapter18/UsingRandomAccessFile.data";
	
	static void display() throws Exception {
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		for(int i=0;i<7;i++) {
			System.out.println("Value " + i + ": " + rf.readDouble());
		}
		System.out.println(rf.readUTF());
		rf.close();
	}
	
	public static void main(String[] args) throws Exception {
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		for(int i=0;i<7;i++)
			rf.writeDouble(i * 1.414);
		rf.writeUTF("The end of the file");
		rf.close();
		display();
		rf = new RandomAccessFile(file, "rw");
		rf.seek(5 * 8);   /*跳过5 * 8字节，相当于跳过5个double*/
		rf.writeDouble(47.0001);  /*覆盖原来的第6个double*/
		rf.close();
		display();
	}
}
/*Value 0: 0.0
Value 1: 1.414
Value 2: 2.828
Value 3: 4.242
Value 4: 5.656
Value 5: 7.069999999999999
Value 6: 8.484
The end of the file
Value 0: 0.0
Value 1: 1.414
Value 2: 2.828
Value 3: 4.242
Value 4: 5.656
Value 5: 47.0001
Value 6: 8.484
The end of the file*/
