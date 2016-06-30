package com.tests.thread;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableTest implements Runnable {
	private final ReentrantLock lock = new ReentrantLock();
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	
	public static void main(String[] args) throws Exception {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "" + i);
			if(i == 5) {
				RunnableTest rt = new RunnableTest();
				Thread thread = new Thread(rt, "子线程1");
				thread.setPriority(Thread.MAX_PRIORITY);
				thread.start();
				
				Thread thread2 = new Thread(rt, "子线程2");
				thread2.setPriority(Thread.MIN_PRIORITY);
				thread2.start();
			}
			
		}
	}
}
