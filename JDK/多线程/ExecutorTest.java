package com.tests.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		
		ThreadTest target = new ThreadTest();
		for(int i = 0; i < 5; i++) {
			pool.submit(target);
		}
	}
}

class ThreadTest implements Runnable {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}
