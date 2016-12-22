package org.thread;

public class RunnableDemo extends Thread {
	private Thread t;
    private String threadName;


	//构造函数
	RunnableDemo( String name) {
		threadName = name;
	    System.out.println("Creating " +  threadName );
	}
	
	@Override
	public void run() {
		System.out.println(threadName+"running...");
	}
	
	/*public void start () {
		if (t == null) {
	         t = new Thread(this, threadName);
	      }
		 t.start ();
	}*/
	
	

}
