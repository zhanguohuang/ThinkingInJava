package org.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 在两个通道之间最直接的通讯
 * @author Administrator
 *
 */
public class TransferTo {

	private static final String BASEPATH = "./src/org/chapter18/TransferTo";
	
	public static void main(String[] args) throws Exception {
		FileChannel in = new FileInputStream(BASEPATH + ".java").getChannel(),
				out = new FileOutputStream(BASEPATH + ".out").getChannel();
		in.transferTo(0, in.size(), out);
		/*out.transferFrom(in, 0, in.size());*/
	}
}
