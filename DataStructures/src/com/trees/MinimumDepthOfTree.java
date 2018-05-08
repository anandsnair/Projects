package com.trees;

public class MinimumDepthOfTree {

	public static void main(String[] args) {
		MinimumDepthOfTree min = new MinimumDepthOfTree();
		Node root = min.buildTree();
		System.out.println(min.minDepth(root));
	}
	private int minDepth(Node root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		if(root.left != null) {
			return minDepth(root.left) + 1;
		}
		if(root.right != null) {
			return minDepth(root.right) + 1;
		}
		return minimum(minDepth(root.left), minDepth(root.right)) +1;
	}
	private int minimum(int minDepth, int minDepth2) {
		if(minDepth < minDepth2)
			return minDepth;
		else 
			return minDepth2;
	}
	private Node buildTree() {
		Node root = new Node(1);
		Node left = new Node(2);
		Node right = new Node(2);
		root.left = left;
		root.right = right;
		Node leftleft = new Node(3);
		Node leftright = new Node(4);
		left.left = leftleft;
		left.right = leftright;
		
		Node leftleftright = new Node(5);
		Node leftleftleft = new Node(6);
		leftleft.left = leftleftleft;
		leftleft.right = leftleftright;
		return root;
	}
}
