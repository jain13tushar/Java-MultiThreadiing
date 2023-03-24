package com.thread.group;

class MyTask implements Runnable {

	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class GroupOfThread {

	public static void main(String[] args) {

		ThreadGroup myGroup = new ThreadGroup("MyGroup");
		myGroup.setMaxPriority(7);

		new Thread(myGroup, new MyTask(), "Tushar").start();

		System.out.println("System threads........");
		Thread thr = Thread.currentThread();
		ThreadGroup grp = thr.getThreadGroup();
		while (grp.getParent() != null) {
			grp = grp.getParent();
		}
		grp.list();
	}

}

//Output
/*System threads........
java.lang.ThreadGroup[name=system,maxpri=10]
    Thread[Reference Handler,10,system]
    Thread[Finalizer,8,system]
    Thread[Signal Dispatcher,9,system]
    Thread[Attach Listener,5,system]
    java.lang.ThreadGroup[name=main,maxpri=10]
        Thread[main,5,main]
        java.lang.ThreadGroup[name=MyGroup,maxpri=7]
            Thread[Tushar,5,MyGroup]
*/
