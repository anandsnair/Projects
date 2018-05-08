package com.trees;

public class LevelOrderTravesal {

	public void printLevelOrder(Node root) {
		int height = getHeight(root);
		for(int i = 0 ; i < height; i++) {
			printGivenLevel(root, i);
		}
	}

	private void printGivenLevel(Node root, int i) {
		if(root == null) 
			return;
		if(i == 0)
			System.out.println(root.data);
		else if(i >= 1) {
			printGivenLevel(root.left, i-1);
			printGivenLevel(root.right, i-1);
		}
	}

	private int getHeight(Node root) {
		if(root == null)
			return 0;
		else {
			int lheight = getHeight(root.left);
			int rheight = getHeight(root.right);
			if(lheight > rheight)
				return lheight+1;
			else return rheight+1;
		}
	}
	
	public static void main(String[] args) {
		LevelOrderTravesal levelOrd = new LevelOrderTravesal();
		Node root = new Node();
		root.data = 1;
		Node lNode = new Node();
		Node rNode = new Node();
		lNode.data = 2;
		rNode.data = 3;
		root.left = lNode;
		root.right = rNode;
		lNode = new Node();
		rNode = new Node();
		lNode.data = 4;
		rNode.data = 5;
		root.left.left=lNode;
		root.left.right=rNode;
		lNode = new Node();
		rNode = new Node();
		lNode.data = 6;
		rNode.data = 7;
		root.right.left=lNode;
		root.right.right=rNode;
		levelOrd.printLevelOrder(root);
	}
}
