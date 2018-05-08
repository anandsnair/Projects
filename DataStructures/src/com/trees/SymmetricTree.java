package com.trees;

public class SymmetricTree {

	/*
	 * Given a binary tree, check whether it is a mirror of itself.
	 */
	
	private boolean isMirror(Node left, Node right) {
		if(left == null && right == null) 
			return true;
		if(left != null && right != null && left.data == right.data) {
			return isMirror(left.left, right.right) && isMirror(left.right, right.left);
		}
		return false;
	}
	
	public static void main(String[] args) {
		SymmetricTree tree = new SymmetricTree();
		Node root = tree.buildSymmetricTree();
		System.out.println(tree.isMirror(root.left, root.right));
	}

	private Node buildSymmetricTree() {
		Node root = new Node(1);
		Node left = new Node(2);
		Node right = new Node(2);
		root.left = left;
		root.right = right;
		Node leftleft = new Node(3);
		Node leftright = new Node(4);
		left.left = leftleft;
		left.right = leftright;
		
		Node rightleft = new Node(3);
		Node rightright = new Node(4);
		right.left = rightleft;
		right.right = rightright;
		return root;
	}
}
