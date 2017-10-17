package io.practical.p0004;

import java.util.concurrent.CountDownLatch;

public class SynchronizedCounter extends SimpleCounter {

	public SynchronizedCounter(CountDownLatch latch) {
		super(latch);
	}

	@Override
	public synchronized void increment() {
		this.counterValue++;
		latch.countDown();
	}

}
