package com.leetcode.medium;

public class NthNodeFromEndOfLL {
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode nod2 = new ListNode(2);
		node.next = nod2;
		NthNodeFromEndOfLL list = new NthNodeFromEndOfLL();
		ListNode result = list.removeNthFromEnd(node, 2);
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	 int sizeOfLL = 0;
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        if(n == 0 || head == null) {
	            return head;
	        } 
	        if(head.next == null && n ==1) {
	            return null;
	        }
	        return findNthNode(null,head, n, 0);
	    }
	    
	    public ListNode findNthNode(ListNode prevNode, ListNode currentNode, int n, int totalSize) {
	       if(currentNode == null) {
	           sizeOfLL = totalSize;
	           return currentNode;
	       } else {
	           findNthNode(currentNode, currentNode.next, n, ++totalSize);
	           if(n == sizeOfLL-totalSize+1) {
	        	   if(prevNode != null) {
		               prevNode.next = currentNode.next;
	        	   }
	        	   else {
	        		   return currentNode.next;
	        	   }
	           }
	           return currentNode;
	       }
	    }
}
