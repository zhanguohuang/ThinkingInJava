package org.chapter18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class FormattedMemoryInput {

	public static void main(String[] args) throws Exception {
		try {
			/*先把数组读进byteArray中，然后用DataInputStream进行封装*/
			DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("./src/org/chapter18/FormattedMemoryInput.java").getBytes()));
			while(true)
				System.out.print((char)in.readByte());
		} catch(Exception e) {
			System.err.println("End of stream");
		}
	}
}
