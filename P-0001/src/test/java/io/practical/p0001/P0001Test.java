package io.practical.p0001;

import org.junit.Test;

public class P0001Test {
	
	@Test
	public void test() {
		ZipCreator zc = new ZipCreator();
		zc.createZip("monZlip.zip");
	}
}
