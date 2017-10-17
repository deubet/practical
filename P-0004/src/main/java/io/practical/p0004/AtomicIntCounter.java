package io.practical.p0004;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntCounter extends SimpleCounter {

	AtomicInteger atomicValue;
	CountDownLatch latch;

	@Override
	public int getCounterValue() {
		return atomicValue.get();
	}

	public AtomicIntCounter(CountDownLatch latch) {
		super(latch);
		this.atomicValue = new AtomicInteger(0);
		this.latch = latch;
	}
	
	@Override
	public void increment() {
		this.atomicValue.incrementAndGet();
		this.latch.countDown();
	}

}
