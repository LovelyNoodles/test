package com.sqyc;

public class TryARM {

	public static void main(String[] args) {

		try {
			MyResource myResource = new MyResource();
			try (MyResource resource = myResource) {
				resource.doSomething();
			} catch (Exception e) {
                System.out.println("main:" + e.getMessage());
            }
			
			myResource.close();
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
