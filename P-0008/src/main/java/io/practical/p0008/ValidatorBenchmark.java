package io.practical.p0008;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class ValidatorBenchmark {
	
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testSaxcl_Sesion56_2() throws InstantiationException {
//		XmlValidator validator = new SaxValidator("xml/cl_Sesion56_2.xml");
//		validator.validate();
//	}
//	
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testSaxeu_COM() throws InstantiationException {
//		XmlValidator validator = new SaxValidator("xml/eu_COM(2013)0619_EN-8.xml");
//		validator.validate();
//	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testSaxit_senato() throws InstantiationException {
		XmlValidator validator = new SaxValidator("xml/it_senato_ddl_2013.xml");
		validator.validate();
	}
	
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testSaxus_Title() throws InstantiationException {
//		XmlValidator validator = new SaxValidator("xml/us_Title9-Chap3-eng.xml");
//		validator.validate();
//	}
//	
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testSaxza_Judg() throws InstantiationException {
//		XmlValidator validator = new SaxValidator("xml/za_Judgement_2008-11-26.xml");
//		validator.validate();
//	}
//
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testDomcl_Sesion56_2() throws InstantiationException {
//		XmlValidator validator = new DomValidator("xml/cl_Sesion56_2.xml");
//		validator.validate();
//	}
//	
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testDomeu_COM() throws InstantiationException {
//		XmlValidator validator = new DomValidator("xml/eu_COM(2013)0619_EN-8.xml");
//		validator.validate();
//	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testDomit_senato() throws InstantiationException {
		XmlValidator validator = new DomValidator("xml/it_senato_ddl_2013.xml");
		validator.validate();
	}
	
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testDomus_Title() throws InstantiationException {
//		XmlValidator validator = new DomValidator("xml/us_Title9-Chap3-eng.xml");
//		validator.validate();
//	}
//	
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testDomza_Judg() throws InstantiationException {
//		XmlValidator validator = new DomValidator("xml/za_Judgement_2008-11-26.xml");
//		validator.validate();
//	}
//	
//
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testValidatorcl_Sesion56_2() throws InstantiationException {
//		XmlValidator validator = new ValidatorValidator("xml/cl_Sesion56_2.xml");
//		validator.validate();
//	}
//	
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testValidatoreu_COM() throws InstantiationException {
//		XmlValidator validator = new ValidatorValidator("xml/eu_COM(2013)0619_EN-8.xml");
//		validator.validate();
//	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void testValidatorit_senato() throws InstantiationException {
		XmlValidator validator = new ValidatorValidator("xml/it_senato_ddl_2013.xml");
		validator.validate();
	}
	
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testValidatorus_Title() throws InstantiationException {
//		XmlValidator validator = new ValidatorValidator("xml/us_Title9-Chap3-eng.xml");
//		validator.validate();
//	}
//	
//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	@Warmup(iterations = 5)
//	public void testValidatorza_Judg() throws InstantiationException {
//		XmlValidator validator = new ValidatorValidator("xml/za_Judgement_2008-11-26.xml");
//		validator.validate();
//	}
	
	}
