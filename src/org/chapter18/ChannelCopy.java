package org.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 需注意两个通道是如何利用Buffer进行传输的
 * @author Administrator
 *
 */
public class ChannelCopy {

	private static final int BSIZE = 1024;
	private static final String BASEPATH = "./src/org/chapter18/ChannelCopy";
	
	public static void main(String[] args) throws Exception {
/*		if(args.length != 2) {
			System.out.println("argsments:　sourcefile destfile");
			System.exit(1);
		}*/
		FileChannel in = new FileInputStream(BASEPATH + ".java").getChannel(),
				out = new FileOutputStream(BASEPATH + ".out").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while(in.read(buffer) != -1) {
			buffer.flip();  //Prepare for writing
			out.write(buffer);
			buffer.clear(); //Prepare for reading
		}
	}
}
