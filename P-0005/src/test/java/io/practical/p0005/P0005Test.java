package io.practical.p0005;

import java.io.IOException;

import org.junit.Test;

public class P0005Test {
	
	@Test
	public void test() {
		MyFileReader mfr = new MyFileReader();
		try {
			mfr.readFile("R:/java/dev/tmp/MonDoc.txt");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
