package io.practical.p0004;


public class TinyCounter implements Runnable {

	private Counter counter;

	private long internalCounter;

	public TinyCounter(Counter counter) {
		super();
		this.counter = counter;
	}
	

	public long getInternalCounter() {
		return internalCounter;
	}

	public void setInternalCounter(long internalCounter) {
		this.internalCounter = internalCounter;
	}

	@Override
	public void run() {
		counter.increment();
	}

}
