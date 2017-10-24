package io.practical.p0006;

import java.util.concurrent.CountDownLatch;

public class SynchronizedInsideCounter extends SimpleCounter {

	public SynchronizedInsideCounter(CountDownLatch latch) {
		super(latch);
	}

	@Override
	public  void increment() {
		synchronized (this) {
			this.counterValue++;
			latch.countDown();
		}
	}

}
