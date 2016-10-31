package org.chapter18;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 输入数组的方法
 * @author Administrator
 *
 */
public class IntBufferDemo {

	private static final int BSIZE = 1024;
	
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer();
		ib.put(new int[]{11, 42, 47, 49, 143, 811, 1016});
		System.out.println(ib.get(3));
		ib.put(3, 1811);
		ib.flip();
		while(ib.hasRemaining()) {
			int i = ib.get();
			System.out.println(i);
		}
	}
}
/*
49
11
42
47
1811
143
811
1016
*/