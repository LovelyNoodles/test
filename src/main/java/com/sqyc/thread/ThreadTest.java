package com.sqyc.thread;

public class ThreadTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getClass());
		System.out.println(Thread.currentThread().getState());
	}
}
