package io.practical.p0007;


import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class MasterCounterBenchmark {
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testNotSynchro() throws InstantiationException {
		int limit = 1_000_000;
		CountDownLatch latch = new CountDownLatch(limit);
		SimpleCounter pc = (SimpleCounter) UnsafeHelper.getUnsafe().allocateInstance(SimpleCounter.class);
		MasterCounter mc = new MasterCounter(pc,latch,limit);
		mc.increment();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSynchro() throws InstantiationException {
		int limit = 1_000_000;
		CountDownLatch latch = new CountDownLatch(limit);
		SimpleCounter pc = (SimpleCounter) UnsafeHelper.getUnsafe().allocateInstance(SynchronizedCounter.class);
		MasterCounter mc = new MasterCounter(pc,latch,limit);
		mc.increment();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSynchroInside() throws InstantiationException {
		int limit = 1_000_000;
		CountDownLatch latch = new CountDownLatch(limit);
		SimpleCounter pc = (SimpleCounter) UnsafeHelper.getUnsafe().allocateInstance(SynchronizedInsideCounter.class);
		MasterCounter mc = new MasterCounter(pc,latch,limit);
		mc.increment();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testAtomic() throws InstantiationException {
		int limit = 1_000_000;
		CountDownLatch latch = new CountDownLatch(limit);
		SimpleCounter pc = (SimpleCounter) UnsafeHelper.getUnsafe().allocateInstance(AtomicIntCounter.class);
		MasterCounter mc = new MasterCounter(pc,latch,limit);
		mc.increment();
	}

}
