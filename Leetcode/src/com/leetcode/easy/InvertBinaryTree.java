package com.leetcode.easy;

import com.leetcode.medium.TreeNode;

/**
 * Invert binary tree
 * @author anair
 *
 */
public class InvertBinaryTree {
	
	public static void main(String[] args) {
		InvertBinaryTree tree = new InvertBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(3);
		TreeNode root3 = new TreeNode(7);
		TreeNode root4 = new TreeNode(5);
		TreeNode root5 = new TreeNode(8);
		TreeNode root6 = new TreeNode(9);
		TreeNode root7 = new TreeNode(4);
		TreeNode root8 = new TreeNode(12);
		TreeNode root9 = new TreeNode(6);
		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;
		root2.left = root5;
		root2.right = root6;
		root3.right = root7;
		root6.left = root8;
		root6.right = root9;
		tree.printTree(root);
		TreeNode result = tree.invertTree(root);
		System.out.println("Result");
		tree.printTree(result);

	}
	
    public TreeNode invertTree(TreeNode root) {
    		if(root == null) {
    			return root;
    		}
    		 else {
        		TreeNode temp = root.left;
        		root.left = root.right;
        		root.right = temp;
        		invertTree(root.left);
        		invertTree(root.right);
        		return root;
        }
        
    }
    
    public void printTree(TreeNode root) {
    	if(root == null) {
    		return;
    	} else {
    		System.out.print(root.val + " " );
    		printTree(root.left);
    		printTree(root.right);
    	}
    }


}
