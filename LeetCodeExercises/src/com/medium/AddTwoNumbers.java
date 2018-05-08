package com.medium;

public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers numbersAdd = new AddTwoNumbers();
		ListNode result = numbersAdd.addTwoNumbers(numbersAdd.createList(1,1),numbersAdd.createList(9,9,9));
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	  private ListNode createList(int f, int s, int t) {
		  ListNode l1 = new ListNode(f);
		  ListNode second = new ListNode(s);
		  ListNode third = new ListNode(t);
		  l1.next = second;
		  second.next = third;
		  return l1;
	}
	  private ListNode createList(int f, int s) {
		  ListNode l1 = new ListNode(f);
		  ListNode second = new ListNode(s);
		  l1.next = second;
		  return l1;
	}

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	  }
	  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		int firstNumberInL1 = l1.val;
		int firstNumberInL2 = l2.val;
		int carryOver = 0;
		result = new ListNode((firstNumberInL1+firstNumberInL2)%10);
		if(firstNumberInL1+firstNumberInL2 >= 10) {
			carryOver = 1;
		}
		ListNode travelNode = result;
		while(l1.next!= null && l2.next != null) {
			l1 = l1.next;
			l2 = l2.next;
			int valueInL1 = l1.val;
			int valueInL2 = l2.val;
			int sum = valueInL1 + valueInL2 +carryOver;
			ListNode node = new ListNode((sum)%10);
			if(sum >= 10) {
				carryOver = 1;
			} else {
				carryOver = 0;
			}
			travelNode.next = node;
			travelNode = node;
		}
		while(l1.next != null) {
			l1 = l1.next;
			int valueInL1 = l1.val;
			int sum = valueInL1  +carryOver;
			ListNode node = new ListNode((sum)%10);
			if(sum >= 10) {
				carryOver = 1;
			} else {
				carryOver = 0;
			}
			travelNode.next = node;
			travelNode = node;
		}
		while(l2.next != null) {
			l2 = l2.next;
			int valueInL2 = l2.val;
			int sum = valueInL2  +carryOver;
			ListNode node = new ListNode((sum)%10);
			if(sum >= 10) {
				carryOver = 1;
			} else {
				carryOver = 0;
			}
			travelNode.next = node;
			travelNode = node;
		}
		if(carryOver >0) {
			ListNode node = new ListNode(carryOver);
			travelNode.next = node;
		}
		
		return result;
	  }
}
