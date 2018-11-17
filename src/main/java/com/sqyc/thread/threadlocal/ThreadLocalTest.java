package com.sqyc.thread.threadlocal;

import java.util.function.Supplier;

public class ThreadLocalTest {
	// ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	ThreadLocal<Long> longLocal = ThreadLocal.withInitial(new Supplier<Long>() {
		@Override
		public Long get() {
			return 0l;
		}
	});
	// ThreadLocal<String> stringLocal = new ThreadLocal<String>();
	ThreadLocal<String> stringLocal = new ThreadLocal<String>() {
		protected String initialValue() {
			return "yyp";
		};
	};

	public void set() {
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
	}

	public long getLong() {
		return longLocal.get();
	}

	public String getString() {
		return stringLocal.get();
	}

	public static void main(String[] args) throws InterruptedException {
		final ThreadLocalTest test = new ThreadLocalTest();

		// test.set();
		System.out.println(test.getLong());
		System.out.println(test.getString());

		Thread thread1 = new Thread() {
			public void run() {
				test.set();
				System.out.println(test.getLong());
				System.out.println(test.getString());
			};
		};
		thread1.start();
		thread1.join();

		System.out.println(test.getLong());
		System.out.println(test.getString());
	}
}