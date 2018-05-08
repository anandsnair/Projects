package com.leetcode.hard;

import com.leetcode.medium.ListNode;

public class ReverseNodeInKGroup {
	
	public static void main(String[] args) {
		ReverseNodeInKGroup rev = new ReverseNodeInKGroup();
		ListNode node = new ListNode(1);
		ListNode nod2 = new ListNode(2);
		ListNode nod3 = new ListNode(3);
		ListNode nod4 = new ListNode(4);
		ListNode nod5 = new ListNode(5);

		node.next = nod2;
		nod2.next = nod3;
		//nod3.next = nod4;
		//nod4.next = nod5;
		
		ListNode result = rev.reverseKGroup(node, 3);
		
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return head;
        if(head.next == null) {
        	return head;
        }
        if(k == 1) {
        	return head;
        }
		ListNode temp = new ListNode(0);
		temp.next = head;
		int len = getLengthOfLL(head);
		if(k > len) {
			return head;
		}
        traverseTillKNode(head, temp, temp, head, k, 1, len);
        return temp.next;
    }
    
   public int getLengthOfLL(ListNode head) {
    	int len = 1;
    	while(head.next!= null) {
    		head = head.next;
    		len++;
    	}
    	return len;
    }

    public ListNode traverseTillKNode(ListNode firstNode, ListNode firstNodePrev, ListNode prevNode, ListNode currentNode, int k, int curr, int len) {
    	if(currentNode == null) {
            return prevNode;
    	} else {
    		ListNode nextNode = currentNode.next;
    		if(curr%k == 1) {
    			firstNode = currentNode;
    			firstNodePrev = prevNode;
    		}
    		int next = curr+1;
            ListNode lastNode = traverseTillKNode(firstNode, firstNodePrev, currentNode, nextNode, k, next, len);
            if(curr%k == 0) {
                ListNode temp = lastNode.next;
                firstNode.next = temp;
                lastNode.next = prevNode;
                firstNodePrev.next = lastNode;
            } else if(curr%k==1 || curr> (len/k) *k) {
            	
            } 
            else {
                lastNode.next = prevNode;
            }
            return prevNode;
        }
    }
}
