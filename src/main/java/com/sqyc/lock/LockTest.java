package com.sqyc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class LockTest {
	public static void main(String[] args) {
		new Lock() {
			
			@Override
			public void unlock() {
			}
			
			@Override
			public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
				return false;
			}
			
			@Override
			public boolean tryLock() {
				return false;
			}
			
			@Override
			public Condition newCondition() {
				return null;
			}
			
			@Override
			public void lockInterruptibly() throws InterruptedException {
			}
			
			@Override
			public void lock() {
			}
		};
	}
}
