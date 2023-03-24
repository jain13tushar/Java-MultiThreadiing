package com.producer.consumer.problem;

import java.util.ArrayList;
import java.util.List;

//Producer and Consumer problem
// producer -> messageQueue -> consumer

class MessageQueue {

	List<String> messages;
	int limit;

	public MessageQueue(int limit) {
		messages = new ArrayList<>();
		this.limit = limit;
	}

	public boolean isFull() {
		return messages.size() == limit;
	}

	public boolean isEmpty() {
		return messages.size() == 0;
	}

	public synchronized void enqueue(String msg) {

		while (isFull()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		messages.add(msg);
		this.notify();

	}

	public synchronized String denqueue() {

		while (isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		String message = messages.remove(0);
		this.notify();
		return message;

	}
}

class ProducerThread extends Thread {
	MessageQueue queue;

	public ProducerThread(MessageQueue queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 1; i < 10; i++) {
			String msg = "Hello " + i;
			queue.enqueue(msg);
			System.out.println("Produced - " + msg);
		}
	}
}

class ConsumerThread extends Thread {
	MessageQueue queue;

	public ConsumerThread(MessageQueue queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 1; i < 10; i++) {
			String msg = queue.denqueue();
			System.out.println("Consumed - " + msg);
		}
	}
}

// One approach is to ask the producer 
// to wait till the message is consumed.
public class ProducerConsumerEx {

	public static void main(String[] args) {

		MessageQueue queue = new MessageQueue(1);
		new ProducerThread(queue).start();
		new ConsumerThread(queue).start();

	}
}
