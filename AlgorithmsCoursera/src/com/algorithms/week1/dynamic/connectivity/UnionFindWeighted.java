package com.algorithms.week1.dynamic.connectivity;

public class UnionFindWeighted {
	int numberOfObjects;
	int[] array;
	int[] size;
	public UnionFindWeighted(int numberOfObjects) {
		this.numberOfObjects = numberOfObjects;
		array = new int[numberOfObjects];
		size = new int[numberOfObjects];
		for(int i = 0; i < numberOfObjects ; i++) {
			array[i] = i;
			size[i] = 1;
		}
	}
	
	private int findRoot(int node) {
		if(array[node] == node) {
			return node;
		} else {
			return findRoot(array[node]);
		}
	}
	
	public void union(int p, int q) {
		//To merge components containing p and q, the shortest tree is connected to the largest tree.
		int rootQ = findRoot(array[q]);
		int rootP = findRoot(array[p]);
		if(rootQ == rootP) 
			return;
		if(size[rootP] < size[rootQ]) {
			array[rootP] = array[rootQ];
			size[rootQ] = size[rootQ] + size[rootP];
			System.out.println("Union of "+q+" and "+p+"");

		} else {
			array[rootQ] = array[rootP];
			size[rootP] = size[rootQ] + size[rootP];
			System.out.println("Union of "+p+" and "+q+"");

		}
	}
	
	public boolean connected(int p, int q) {
		//Check if both p and q has same roots.
		if(findRoot(array[p]) == findRoot(array[q]))
			return true;
		return false;
	}
	public void printArray() {
		for(int i = 0 ; i < array.length ; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		UnionFindWeighted uf = new UnionFindWeighted(10);
		uf.union(4, 3);
		uf.printArray();
		uf.union(3, 8);
		uf.printArray();
		uf.union(6, 5);
		uf.printArray();
		uf.union(9, 4);
		uf.printArray();
		uf.union(2, 1);
		uf.printArray();
		System.out.println(uf.connected(8, 9));
		System.out.println(uf.connected(5, 4));
		uf.union(5, 0);
		uf.printArray();
		uf.union(7, 2);
		uf.printArray();
		uf.union(6, 1);
		uf.printArray();
		uf.union(7, 3);
		uf.printArray();

	}
}
