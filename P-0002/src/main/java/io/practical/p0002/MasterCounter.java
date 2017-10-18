package io.practical.p0002;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class MasterCounter {

	public void increment() {
		ForkJoinPool pool = new ForkJoinPool();
		TinyCounter counter1 = new TinyCounter("Jack", 10000);
		TinyCounter counter2 = new TinyCounter("Xa", 10000);
		TinyCounter counter3 = new TinyCounter("Marc", 10000);
		TinyCounter counter4 = new TinyCounter("Aurore", 10000);
		pool.execute(counter1);
		pool.execute(counter2);
		pool.execute(counter3);
		pool.execute(counter4);
		do {
			try {
				System.out.println("Je sens que c'est pas prêt, je vais faire une tite sieste");
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while ((!counter1.isDone()) || (!counter2.isDone()) || (!counter3.isDone()) || (!counter4.isDone()));
		pool.shutdown();
		System.out.println("Ayé !!! Tout le monde a bien compté !!!");
		System.out.println(counter1.getName() + " a mis " + counter1.join() + " ms");
		System.out.println(counter2.getName() + " a mis " + counter2.join() + " ms");
		System.out.println(counter3.getName() + " a mis " + counter3.join() + " ms");
		System.out.println(counter4.getName() + " a mis " + counter4.join() + " ms");
	}
}
