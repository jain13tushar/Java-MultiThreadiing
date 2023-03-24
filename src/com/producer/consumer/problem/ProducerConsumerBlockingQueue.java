package com.producer.consumer.problem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread {
	BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			String msg = "Hello " + i;

			try {
				queue.put(msg);
				System.out.println("Produced - " + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread {
	BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			String msg = null;

			try {
				msg = queue.take();
				System.out.println("Consumed - " + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// Another approach is to implement using blocking queue.
public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) {

		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
		new Producer(queue).start();
		new Consumer(queue).start();

	}

}
