package io.practical.p0006;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MasterCounter {

	private SimpleCounter counter;
	
	private CountDownLatch latch;
	
	public CountDownLatch getLatch() {
		return latch;
	}

	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	private int limit;

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(SimpleCounter counter) {
		this.counter = counter;
	}
	
	public MasterCounter(SimpleCounter counter, CountDownLatch latch, int limit) {
		super();
		this.counter = counter;
		this.latch = latch;
		this.limit = limit;
		this.counter.setLatch(this.latch);
	}

	public void increment() {
		ExecutorService executorService = Executors.newFixedThreadPool(12);
		for (int i = 0; i < limit; i++) {
			executorService.execute(counter);
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}
}
