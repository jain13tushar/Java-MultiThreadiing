package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyMath {
	public static int add(int a, int b) {
		return a + b;
	}
}

public class CallableImplementation {

	public static void main(String[] args) throws Exception {

		int x = 10;
		int y = 20;

		ExecutorService executorService = Executors.newFixedThreadPool(1);

		Future<Integer> future = executorService.submit(new Callable<Integer>() {
			public Integer call() {
				return MyMath.add(x, y);
			}
		});

		while (!future.isDone())
			;
		int z = future.get();

		System.out.println("Result is " + z);

	}

}
