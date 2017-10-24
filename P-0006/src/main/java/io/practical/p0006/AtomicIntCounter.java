package io.practical.p0006;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntCounter extends SimpleCounter {

	private AtomicInteger atomicValue;

	@Override
	public int getCounterValue() {
		return atomicValue.get();
	}

	public AtomicIntCounter(CountDownLatch latch) {
		super(latch);
		this.latch = latch;
	}
	
	@Override
	public void increment() throws InstantiationException {
		if (this.atomicValue == null)
		{
			this.atomicValue = (AtomicInteger) UnsafeHelper.getUnsafe().allocateInstance(AtomicInteger.class);
			this.atomicValue.set(0);
		}
		this.atomicValue.incrementAndGet();
		this.latch.countDown();
	}

}
