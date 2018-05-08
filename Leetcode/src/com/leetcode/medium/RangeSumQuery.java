package com.leetcode.medium;


public class RangeSumQuery {
	int[] nums;
	TreeNode tree;
	
	private RangeSumQuery(int[] nums) {
		this.nums = nums;
		tree = buildTree(nums, 0, nums.length-1);
	}
	public static void main(String[] args) {
		int inputArray[] = new int[7];
		inputArray[0] = 4;
		inputArray[1] = 10;
		inputArray[2] = 42;
		inputArray[3] = 3;
		inputArray[4] = 5;
		inputArray[5] = 7;
		inputArray[6] = 8;
		RangeSumQuery range = new RangeSumQuery(inputArray);
		range.inorder(range.tree);
		range.update(range.tree, 3, 4);
		System.out.println();
		range.inorder(range.tree);
		System.out.println();
		System.out.println(range.sumRange(2, 5));

	}

	private void update(TreeNode node, int position, int value) {
        int oldValue = nums[position];
        while(node != null) {
        	int mid = node.start + (node.end-node.start)/2;
        	node.sum = node.sum - oldValue + value;
        	if(mid>= position) {
        		node = node.left;
        	} else {
        		node = node.right;
        	}
        }
        nums[position] = value;

	}
    private void inorder(TreeNode tree) {
    	if(tree == null)
    		return;
    	inorder(tree.left);
    	System.out.print(tree.sum + " ");
    	inorder(tree.right);
	}
    
	void update(int i, int val) {
        update(tree , i, val);
    }

    public int sumRange(int i, int j) {
    	return sumRange(tree, i, j);
    }
    
    public int sumRange(TreeNode node, int i, int j) {
    	if(node == null) {
    		return 0;
    	}
    	if(i <= node.start && j >= node.end) {
    		return node.sum;
    	} else {
    		return sumRange(node.left, i, j) + sumRange(node.right, i, j);
    	}
    }

    
    public TreeNode buildTree(int[] nums, int start, int end) {
    	if(start > end)
    		return null;
    	if(start == end) {
        	TreeNode node = new TreeNode();
        	node.sum = nums[start];
        	node.start = start;
        	node.end = end;
        	return node;
    	}
    	int sum = 0;
    	for(int i = start ; i <= end ; i++) {
    		sum+= nums[i];
    	}
    	TreeNode node = new TreeNode();
    	node.sum = sum;
    	node.start = start;
    	node.end = end;
        int mid = start + (end-start)/2;
        node.left = buildTree(nums, start, mid);
        node.right = buildTree(nums, mid+1, end);
    	
        return node;
    }
    class TreeNode { 
    	int sum;
    	TreeNode left;
    	TreeNode right;
    	int start;
    	int end;
    }
}
