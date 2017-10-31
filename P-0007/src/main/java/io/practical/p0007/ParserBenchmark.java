package io.practical.p0007;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class ParserBenchmark {
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSaxNation() throws InstantiationException {
		MyXmlParser parser = new MySaxParser("nation.xml");
		parser.parse();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSaxReed() throws InstantiationException {
		MyXmlParser parser = new MySaxParser("reed.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSaxOrders() throws InstantiationException {
		MyXmlParser parser = new MySaxParser("orders.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSaxLineItem() throws InstantiationException {
		MyXmlParser parser = new MySaxParser("lineitem.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSaxSlide3() throws InstantiationException {
		MyXmlParser parser = new MySaxParser("slide3.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSaxDocument() throws InstantiationException {
		MyXmlParser parser = new MySaxParser("document.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSaxStyles() throws InstantiationException {
		MyXmlParser parser = new MySaxParser("styles.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testDomNation() throws InstantiationException {
		MyXmlParser parser = new MyDomParser("nation.xml");
		parser.parse();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testDomReed() throws InstantiationException {
		MyXmlParser parser = new MyDomParser("reed.xml");
		parser.parse();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testDomOrders() throws InstantiationException {
		MyXmlParser parser = new MyDomParser("orders.xml");
		parser.parse();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testDomLineItem() throws InstantiationException {
		MyXmlParser parser = new MyDomParser("lineitem.xml");
		parser.parse();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testDomSlide3() throws InstantiationException {
		MyXmlParser parser = new MyDomParser("slide3.xml");
		parser.parse();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testDomDocument() throws InstantiationException {
		MyXmlParser parser = new MyDomParser("document.xml");
		parser.parse();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testDomStyles() throws InstantiationException {
		MyXmlParser parser = new MyDomParser("styles.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testStaxNation() throws InstantiationException {
		MyXmlParser parser = new MyStaxParser("nation.xml");
		parser.parse();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testStaxReed() throws InstantiationException {
		MyXmlParser parser = new MyStaxParser("reed.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testStaxOrders() throws InstantiationException {
		MyXmlParser parser = new MyStaxParser("orders.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testStaxLineItem() throws InstantiationException {
		MyXmlParser parser = new MyStaxParser("lineitem.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testStaxSlide3() throws InstantiationException {
		MyXmlParser parser = new MyStaxParser("slide3.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testStaxDocument() throws InstantiationException {
		MyXmlParser parser = new MyStaxParser("document.xml");
		parser.parse();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testStaxStyles() throws InstantiationException {
		MyXmlParser parser = new MyStaxParser("styles.xml");
		parser.parse();
	}
	}
