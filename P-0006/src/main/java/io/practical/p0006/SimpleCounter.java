package io.practical.p0006;

import java.util.concurrent.CountDownLatch;

public class SimpleCounter implements Counter, Runnable {

	int counterValue = 0;

	CountDownLatch latch;

	@Override
	public int getCounterValue() {
		return counterValue;
	}

	public void setCounterValue(int counterValue) {
		this.counterValue = counterValue;
	}

	
	
	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	public SimpleCounter(CountDownLatch latch) {
		this.counterValue = 0;
		this.latch = latch;
	}
	
	@Override
	public void increment() throws InstantiationException {
		this.counterValue++;
		latch.countDown();
	}

	@Override
	public void run() {
		try {
			this.increment();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
