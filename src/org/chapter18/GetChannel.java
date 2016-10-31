package org.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 需深刻理解Channel与Buffer之间的合作关系
 * @author Administrator
 *
 */
public class GetChannel {

	private static final int BSIZE = 1024;
	private static final String BASEPATH = "./src/org/chapter18/GetChannel";
	
	public static void main(String[] args) throws Exception {
		/*FileInputStream到底层源码是一个的open的方法,getChannel()未知*/
		FileChannel fc = new FileOutputStream(BASEPATH + ".data").getChannel();
		/*相当于送入了缓冲器，产生了一个ByteBuffer对象  HeapByteBuffer ByteBuffer(abstract) Buffer(implements) */
		fc.write(ByteBuffer.wrap("Some  text ".getBytes()));
		/*close()方式是查看open是否为true，然后去调用操作系统底层去关闭文件*/
		fc.close();
		fc = new RandomAccessFile(BASEPATH + ".data", "rw").getChannel();
		fc.position(fc.size());   /*移动指针到文件的结尾*/
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();
		fc = new FileInputStream(BASEPATH + ".data").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();  /*表示已经装满，定位缓冲指针*/
		while(buff.hasRemaining())
			/*卸货*/
			System.out.print((char)buff.get());   
	}
}

/*
Some  text Some more
*/
