package com.anand.multithreading;

class Worker implements Runnable {

	private volatile boolean isTerminated = false;
	@Override
	public void run() {
		while(!isTerminated) {
			System.out.println("Hello ...");
			
		}
	}
	public boolean isTerminated() {
		return isTerminated;
	}
	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
	
	
}
public class VolatileKeywordExample {

	public static void main(String[] args) {
		Worker worker = new Worker();
		Thread t1 = new Thread(worker);
		t1.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		worker.setTerminated(true);
		System.out.println("Finished");
	}
}
