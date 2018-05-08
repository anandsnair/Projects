package com.leetcode.easy;

import com.leetcode.medium.ListNode;

public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		MergeTwoSortedArrays merge = new MergeTwoSortedArrays();
		ListNode l2 = new ListNode(0);
		ListNode result = merge.mergeTwoLists(null, l2);
		
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 	ListNode head = new ListNode(0);
		 	ListNode lastNode = head;
	        ListNode newNode = null;

	        while(l1 != null && l2 != null) {
	            if(l1.val >l2.val) {
	                newNode = new ListNode(l2.val);
	                lastNode.next = newNode;
	                lastNode = lastNode.next;
	               // newNode = newNode.next;
	                l2 = l2.next;
	            } else {
	                newNode = new ListNode(l1.val);
	                lastNode.next = newNode;
	                lastNode = lastNode.next;
	               // newNode = newNode.next;
	                l1 = l1.next;
	            }
	        }
	        while(l1 != null) {
	            newNode = new ListNode(l1.val);
	            lastNode.next = newNode;
                lastNode = lastNode.next;
               // newNode = newNode.next;
                l1 = l1.next;
	        }
	        while(l2 != null) {
	            newNode = new ListNode(l2.val);
	            lastNode.next = newNode;
                lastNode = lastNode.next;
               // newNode = newNode.next;
                l2 = l2.next;
	        }
	        return head.next;
	    }
}
