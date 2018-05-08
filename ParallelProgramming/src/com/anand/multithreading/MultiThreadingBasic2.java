package com.anand.multithreading;


class Runner3 extends Thread{

	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println("Runner1:"+i);
		}		
	}
}

class Runner4 extends Thread{

	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println("Runner2:"+i);
		}		
	}
}

public class MultiThreadingBasic2 {

	public static void main(String[] args) {
		Runner3 t1 = new Runner3();
		Runner4 t2 = new Runner4();

		t1.start();
		t2.start();
	}
}
