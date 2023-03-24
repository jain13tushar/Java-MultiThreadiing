package com.approaches.in.multithreading;

class MyThread extends Thread {

	public void run() {
		for (int i = 0; i < 1500; i++) {
			System.out.print("T");
		}
	}

}

class MyTask implements Runnable {

	public void run() {
		for (int i = 0; i < 1500; i++) {
			System.out.print("-");
		}
	}

}

public class TwoApproachs {

	public static void main(String[] args) {

		MyThread myThread = new MyThread();
		myThread.start();

		Thread th = new Thread(new MyTask());
		th.start();

		for (int i = 0; i < 1500; i++) {
			System.out.print("M");
		}

	}

}
