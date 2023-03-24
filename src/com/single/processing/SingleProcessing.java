package com.single.processing;

class MyTask {

	public void doTask() {
		for (int i = 0; i < 1500; i++) {
			System.out.print("T");
		}
	}
}

public class SingleProcessing {

	public static void main(String[] args) {

		for (int i = 0; i < 1500; i++) {
			System.out.print("M");
		}

		MyTask t1 = new MyTask();
		t1.doTask();
	}
}
