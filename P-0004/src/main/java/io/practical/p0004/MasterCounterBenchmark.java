package io.practical.p0004;

import java.util.concurrent.CountDownLatch;
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
	public void testNotSynchro() {
		int limit = 1_000;
		CountDownLatch latch = new CountDownLatch(limit);
		SimpleCounter pc = new SimpleCounter(latch);
		MasterCounter mc = new MasterCounter(pc,latch,limit);
		mc.increment();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSynchro() {
		int limit = 1_000;
		CountDownLatch latch = new CountDownLatch(limit);
		SimpleCounter pc = new SynchronizedCounter(latch);
		MasterCounter mc = new MasterCounter(pc,latch,limit);
		mc.increment();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSynchroInside() {
		int limit = 1_000;
		CountDownLatch latch = new CountDownLatch(limit);
		SimpleCounter pc = new SynchronizedInsideCounter(latch);
		MasterCounter mc = new MasterCounter(pc,latch,limit);
		mc.increment();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testAtomic() {
		int limit = 1_000;
		CountDownLatch latch = new CountDownLatch(limit);
		SimpleCounter pc = new AtomicIntCounter(latch);
		MasterCounter mc = new MasterCounter(pc,latch,limit);
		mc.increment();
	}

}
