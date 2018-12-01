package com.sqyc;

public class TryARM {

	public static void main(String[] args) {

		try {
			try (MyResource resource = new MyResource()) {
				resource.doSomething();
			} catch (Exception e) {
                System.out.println("main:" + e.getMessage());
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("end ...");

	}

	static class MyResource implements AutoCloseable {

		public void doSomething() {
			System.out.println("do something ...");
			throw new RuntimeException("occur error in do something");
		}

		public void close() throws Exception {
			System.out.println("my resource is closed ...");
			throw new RuntimeException("occur error in closed");
		}
	}
}
