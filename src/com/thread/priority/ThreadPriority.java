package com.thread.priority;

class CopyTask implements Runnable {

	public void run() {
		while (true) {
			System.out.print("C");
		}
	}
}

class ProgressTask implements Runnable {

	public void run() {
		while (true) {
			System.out.print("-");
		}
	}
}

public class ThreadPriority {

	public static void main(String[] args) {

		Thread copyThread = new Thread(new CopyTask());
		copyThread.setPriority(Thread.NORM_PRIORITY + 3);
		copyThread.start();

		Thread progressThread = new Thread(new ProgressTask());
		progressThread.start();

	}

}
