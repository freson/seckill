package org.thread;

public class TestThread {

		public static void main(String[] args) {
			Thread t1 = new RunnableDemo("thread1");
			t1.run();
			RunnableDemo t2 = new RunnableDemo("thread2");
			t2.run();
		}
}
