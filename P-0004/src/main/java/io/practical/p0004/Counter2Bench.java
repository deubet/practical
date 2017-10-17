package io.practical.p0004;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Counter2Bench {

	
	public void bench() {
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		
		
		CountDownLatch latch = new CountDownLatch(100_000);
		CounterJack c = new CounterJack(latch);
		
		
		for (int i = 0 ; i < 100_000 ; i++) {
			executorService.execute(c);
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(c.value);
		
	}
	
	public class CounterJack implements Runnable {
		
		private int value;
		private CountDownLatch latch;
		
		public CounterJack(CountDownLatch latch2) {
			this.latch = latch2;
		}

		public void inc() {
			value++;
		}

		@Override
		public  void run() {
			inc();
			latch.countDown();
			
		}
		
	}
}
