package org.chapter18;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {

	/**
	 * mark()会将mark记录到当前position的值，reset会将position调回到mark
	 * put方法则会将position往后移
	 * @param buffer
	 */
	private static void symmetricScramble(CharBuffer buffer) {
		while(buffer.hasRemaining()) {
			buffer.mark();
			char c1 = buffer.get();
			char c2 = buffer.get();
			buffer.reset();
			buffer.put(c2).put(c1);
		}
	}
	
	public static void main(String[] args) {
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		/*rewind()重新回到开头*/
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
	}
}
