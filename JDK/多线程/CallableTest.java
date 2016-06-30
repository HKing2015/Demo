package com.tests.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {
	public Integer call() {
		int i = 0;
		for(; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		return i;
	}
	
	public static void main(String[] args) {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		CallableTest ct = new CallableTest();
		FutureTask<Integer> task = new FutureTask<Integer>(ct);
		
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i == 2) {
				Thread th = new Thread(task, "call线程");
				th.setPriority(Thread.MAX_PRIORITY);
				th.start();
			}
		}
		
		try {
			System.out.println("call线程返回值" + task.get());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
