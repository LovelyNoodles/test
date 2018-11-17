package com.sqyc.thread;

import java.io.InputStream;
import java.io.OutputStream;

public class ThreadTest {
	public static void main(String[] args) {
		Thread thread = new Thread();
		new Process() {
			
			@Override
			public int waitFor() throws InterruptedException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public OutputStream getOutputStream() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public InputStream getInputStream() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public InputStream getErrorStream() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int exitValue() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void destroy() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
