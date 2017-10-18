package io.practical.p0005;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

import sun.misc.Unsafe;

public class MyFileReader {

	public void readFile(String filename) throws IOException, NoSuchFieldException, SecurityException {
		RandomAccessFile aFile = new RandomAccessFile(filename, "r");
		FileChannel inChannel = aFile.getChannel();
		MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
		Unsafe myUnsafe = UnsafeHelper.getUnsafe();
		long truc = myUnsafe.objectFieldOffset(Buffer.class.getDeclaredField("address"));
		long pointeur = myUnsafe.getLong(buffer, truc);
		long limit = pointeur + buffer.limit();
		while (pointeur < limit) {
			byte[] mesBytes;
			if (limit - pointeur >= 8) {
				ByteBuffer buff = ByteBuffer.allocate(Long.BYTES).order(ByteOrder.nativeOrder());
				mesBytes = buff.putLong(myUnsafe.getLong(pointeur)).array();
				pointeur += 8;
			}
			else if (limit - pointeur >= 4) {
				ByteBuffer buff = ByteBuffer.allocate(Integer.BYTES).order(ByteOrder.nativeOrder());
				mesBytes = buff.putInt(myUnsafe.getInt(pointeur)).array();
				pointeur += 4;
			}
			else if (limit - pointeur >= 2) {
				ByteBuffer buff = ByteBuffer.allocate(Short.BYTES).order(ByteOrder.nativeOrder());
				mesBytes = buff.putShort(myUnsafe.getShort(pointeur)).array();
				pointeur += 2;
			}
			else {
				ByteBuffer buff = ByteBuffer.allocate(Byte.BYTES).order(ByteOrder.nativeOrder());
				mesBytes = buff.put(myUnsafe.getByte(pointeur)).array();
				pointeur += 1;
			}
			for (byte b : mesBytes)
			{
				System.out.println((char) b);
			}
		}
		buffer.clear();
		inChannel.close();
		aFile.close();
	}

}
