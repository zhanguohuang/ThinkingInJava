package org.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 这里提出了一个问题，如果要想让byte转char后读写都是符合编码的，要么在读入的数据是经过转码的
 * 要么直接用Char的形式写入
 * @author Administrator
 *
 */
public class BufferToText {

	private static final int BSIZE = 1024;
	private static final String BASEPATH = "./src/org/chapter18/BufferToText";
	
	public static void main(String[] args) throws Exception {
		FileChannel fc = new FileOutputStream(BASEPATH + ".data2").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		fc = new FileInputStream(BASEPATH + ".data2").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		//Doesn't work;
		System.out.println(buff.asCharBuffer());
		buff.rewind();	//回到原地
		String encoding = System.getProperty("file.encoding");
		System.out.println("Decoding using " + encoding + ": " + Charset.forName(encoding).decode(buff));
		fc = new FileOutputStream(BASEPATH + ".data2").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		fc = new FileInputStream(BASEPATH + ".data2").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		//Use a CharBuffer to write through;
		fc = new FileOutputStream(BASEPATH + ".data2").getChannel();
		buff = ByteBuffer.allocate(24);
		buff.asCharBuffer().put("Some text");
		fc.write(buff);
		fc.close();
		//Read and display
		fc = new FileInputStream(BASEPATH + ".data2").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
	}
}

/*
卯浥⁴數
Decoding using UTF-8: Some text
Some text
Some text
*/
