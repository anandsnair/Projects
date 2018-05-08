package com.anand.syncblocks;

public class SyncBlockOnMultipleLocks {

	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.work();
	}
}
