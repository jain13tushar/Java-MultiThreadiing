package com.parallel.processing;

class MyTask extends Thread {

	public void run() {
		doTask();
	}

	public void doTask() {
		for (int i = 0; i < 1500; i++) {
			System.out.print("T");
		}
	}

}

public class ParallelProcessing {

	public static void main(String[] args) {

		MyTask myTask = new MyTask();
		myTask.start();

		for (int i = 0; i < 1500; i++) {
			System.out.print("M");
		}

	}

}
