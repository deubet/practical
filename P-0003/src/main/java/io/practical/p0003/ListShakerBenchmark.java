package io.practical.p0003;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class ListShakerBenchmark {

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Warmup(iterations = 5)
	public void testArrayList()
	{
		ListShaker ls = new ListShaker(new ArrayList<Integer>());
		ls.shakeList();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Warmup(iterations = 5)
	public void testLinkedList()
	{
		ListShaker ls = new ListShaker(new LinkedList<Integer>());
		ls.shakeList();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Warmup(iterations = 5)
	public void testVector()
	{
		ListShaker ls = new ListShaker(new Vector<Integer>());
		ls.shakeList();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Warmup(iterations = 5)
	public void testCopyOnWriteArrayList()
	{
		ListShaker ls = new ListShaker(new CopyOnWriteArrayList<Integer>());
		ls.shakeList();
	}
}
