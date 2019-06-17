package ttl.thread;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {

	public static void main(String[] args) throws IOException {

		IndexGenerator generator = new IndexGenerator();

		Worker worker = new Worker("Worker 1", generator);
		Thread th = new Thread(worker);
		th.setDaemon(true);

		Worker worker2 = new Worker("Worker 2", generator);
		Thread th2 = new Thread(worker2);
		th2.setDaemon(true);

		th.start();
		th2.start();
		
		System.out.print("Hit Enter to Exit");
		System.in.read();
		
		int finalIndex = generator.getNextIndex();
		
		System.out.println(finalIndex);
	}
}

class IndexGenerator
{
	//private int nextIndex = 0;
	private AtomicInteger nextIndex = new AtomicInteger(0);
	
	public synchronized int getNextIndex() {
			//return nextIndex++;
			return nextIndex.getAndIncrement();
	}
}

class Worker implements Runnable {
	private String name;
	private IndexGenerator generator;
	int sum;
	public Object syncObject = new Object();

	public Worker(String name, IndexGenerator generator) {
		this.name = name;
		this.generator = generator;
	}

	@Override
	public void run() {
		for(;;) {
				int index = generator.getNextIndex();
		}
	}
	
	public int getSum() {
			return sum;
	}

}



class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}

	public void run() {
		System.out.println("Hello from " + getName());
	}
}