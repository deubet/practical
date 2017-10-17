package io.practical.p0004;

import java.util.concurrent.CountDownLatch;

public class SimpleCounter implements Counter, Runnable {

	int counterValue;

	CountDownLatch latch;

	@Override
	public int getCounterValue() {
		return counterValue;
	}

	public void setCounterValue(int counterValue) {
		this.counterValue = counterValue;
	}

	public SimpleCounter(CountDownLatch latch) {
		this.counterValue = 0;
		this.latch = latch;
	}
	
	@Override
	public void increment() {
		this.counterValue++;
		latch.countDown();
	}

	@Override
	public void run() {
		this.increment();
	}

}
