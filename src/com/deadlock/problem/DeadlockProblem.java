package com.deadlock.problem;

class Writer1 extends Thread {

	Object book;
	Object pen;

	public Writer1(Object book, Object pen) {
		this.book = book;
		this.pen = pen;
	}

	public void run() {
		synchronized (book) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (pen) {
				System.out.println("Writer1 writing");
			}
		}
	}

}

class Writer2 extends Thread {

	Object book;
	Object pen;

	public Writer2(Object book, Object pen) {
		this.book = book;
		this.pen = pen;
	}

	public void run() {
		synchronized (pen) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (book) {
				System.out.println("Writer2 writing");
			}
		}
	}

}

public class DeadlockProblem {

	public static void main(String[] args) {

		Object book = new Object();
		Object pen = new Object();

		new Writer1(book, pen).start();
		new Writer2(book, pen).start();

		System.out.println("Main is done");

	}

}

// Lock Sequencing is one possible solution for deadlock avoidance. 
