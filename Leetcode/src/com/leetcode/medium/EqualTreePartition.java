package com.leetcode.medium;

public class EqualTreePartition {
	
	public static void main(String[] args) {
		EqualTreePartition tree = new EqualTreePartition();
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(3);
		TreeNode root3 = new TreeNode(7);
		TreeNode root4 = new TreeNode(2);
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
		tree.checkEqualTree(root);
	}
    public boolean checkEqualTree(TreeNode root) {
    	if(root.left == null && root.right == null) {
    		return false;
    	}
    	boolean isEqual = false;
    	//printTree(root);
        changeTreeToHaveSum(root);
    	//printTree(root);
    	isEqual = checkForTheBranch(root, root.val);
    	System.out.println(isEqual);
        return isEqual;
    }
    
    public int changeTreeToHaveSum(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
        if(root.left == null && root.right == null) {
            return root.val;
        } else {
            int left = changeTreeToHaveSum(root.left);
            int right = changeTreeToHaveSum(root.right);
            root.val = left + right + root.val;
            return root.val;
        }
    }
    public boolean checkForTheBranch(TreeNode root, int rootValue) {
    	boolean isEqual = false;
    	if(root!= null) {
    		if(root.val*2 == rootValue) {
    			isEqual = true;
    		} else {
    			return checkForTheBranch(root.left, rootValue) || checkForTheBranch(root.right, rootValue);
    		}
    	} 
    	return isEqual;
    }
    
    public void printTree(TreeNode root) {
    	if(root == null) {
    		return;
    	} else {
    		printTree(root.left);
    		printTree(root.right);
    		System.out.print(root.val + " " );
    	}
    }

}
