package com.algorithms.week1.dynamic.connectivity;


public class UnionFind {

	int numberOfObjects;
	int[] array;
	public UnionFind(int numberOfObjects) {
		this.numberOfObjects = numberOfObjects;
		array = new int[numberOfObjects];
		for(int i = 0; i < numberOfObjects ; i++) {
			array[i] = i;
		}
	}
	
	public void union(int p, int q) {
		int idP = array[p];
		int idQ = array[q];
		for(int i = 0 ; i < numberOfObjects ;i++) {
			if(array[i] == idP)
				array[i] = idQ;

		}
	}
	
	public boolean connected(int p, int q) {
		if(array[p] == array[q])
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		UnionFind uf = new UnionFind(10);
		uf.union(3, 5);
		uf.union(5, 9);
		uf.union(9, 1);
		System.out.println(uf.connected(1, 3));
	}
}
