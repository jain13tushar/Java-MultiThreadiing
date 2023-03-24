package com.synchronization.problem;

class Sample {

	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	// Without Synchronization - 11
	// With Synchronization - 12
	public synchronized void incr() {
		int y = getX();
		y++;

		// Demo Purpose
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		setX(y);
	}
}

class MyThread extends Thread {

	Sample obj;

	public MyThread(Sample obj) {
		this.obj = obj;
	}

	public void run() {
		obj.incr();
	}
}

public class SyncProbAndSol {

	public static void main(String[] args) {

		Sample obj = new Sample();
		obj.setX(10);

		MyThread t1 = new MyThread(obj);
		MyThread t2 = new MyThread(obj);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(obj.getX());

	}

}
