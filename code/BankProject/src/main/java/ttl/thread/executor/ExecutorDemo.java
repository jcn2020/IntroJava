package ttl.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorDemo {

	public static void main(String[] args) {
		IndexGenerator generator = new IndexGenerator();
		
		 ExecutorService service = 
				 Executors.newFixedThreadPool(5);

		Worker worker = new Worker("Worker 1", generator);

		Future<?> f1 = service.submit(worker);
		//Thread th = new Thread(worker);

		Worker worker2 = new Worker("Worker 2", generator);
		Future<?> f2 = service.submit(worker2);
		
		

			try {
				f1.get();
				f2.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

		
		int finalIndex = generator.getNextIndex();
		
		CallableWorker callableWorker = new CallableWorker("Worker 3", generator);
		Future<Integer> result = service.submit(callableWorker);
		
		try {
			Integer i = result.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		service.shutdown();
		
		System.out.println(finalIndex);
	}
}

class IndexGenerator
{
	//private int nextIndex = 0;
	private AtomicInteger nextIndex = new AtomicInteger(0);
	
	public int getNextIndex() {
			//return nextIndex++;
			return nextIndex.getAndIncrement();
	}
}

class CallableWorker implements Callable<Integer> {
	private String name;
	private IndexGenerator generator;
	int sum;
	public Object syncObject = new Object();

	public CallableWorker(String name, IndexGenerator generator) {
		this.name = name;
		this.generator = generator;
	}

	@Override
	public Integer call() {
		for(int i = 0; i < 2000; i++) {
				sum += i;
		}
		
		return sum;
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
		for(int i = 0; i < 2000; i++) {
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