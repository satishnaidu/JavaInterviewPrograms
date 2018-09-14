package com.sample.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrintABC {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		List<Callable<String>> callables = new ArrayList<Callable<String>>();
		Callable<String> a = new MyThread2("A");
		Callable<String> b = new MyThread2("B");
		Callable<String> c = new MyThread2("C");

		callables.add(a);
		callables.add(b);
		callables.add(c);

		List<Future<String>> results = executorService.invokeAll(callables);
		for (Future<String> result : results) {
			System.out.println(result.get().toString());
		}

		executorService.shutdown();	
	}
}

class MyThread2 implements Callable<String> {
	private String name;

	public MyThread2(String name) {
		this.name = name;
	}

	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return name;
	}

}
