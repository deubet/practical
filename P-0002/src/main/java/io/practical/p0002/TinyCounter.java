package io.practical.p0002;

import java.util.Calendar;
import java.util.concurrent.RecursiveTask;

public class TinyCounter extends RecursiveTask<Long>{

	private int limit;
	
	private String name;
	
	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public TinyCounter(String name, int limit) {
		super();
		this.limit = limit;
		this.name = name;
	}


	private static final long serialVersionUID = 1L;

	public void increment() {
		for (int i = 0; i <= limit; i++)
		{
			System.out.println(name + " a compté jusque " + i);
		}
		System.out.println(name + " a fini de compter jusque "+ limit +" !!!");
	}

	@Override
	protected Long compute() {
		Long starttime = Calendar.getInstance().getTimeInMillis();
		increment();
		return Calendar.getInstance().getTimeInMillis() - starttime;
	}

}
