package com.datastructures.linkedlist;

public class InsertNodeAtPosition {

	public static void main(String[] args) {
		Node node  = new Node();
		node.setData(1);
		node.setNext(null);
		InsertNodeAtPosition insertNode = new InsertNodeAtPosition();
		Node head = insertNode.InsertNth(node, 2, 0);
		insertNode.printAllNodes(head);
		head = insertNode.insertNodeAtTheTail(head, 5);
		insertNode.printAllNodes(head);
	}
	
	public void printAllNodes(Node head) {
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	Node InsertNth(Node head, int data, int position) {
		    Node insertNode = new Node();
		    insertNode.data = data;
		    int currentPosition = 0;
		    if(head != null && position !=0) {
		    	  Node prevNode = head;
				  Node currentNode = head;
				    while(currentPosition < position) {
				    	prevNode = currentNode;
				    	currentNode = currentNode.next;
				    	++currentPosition;
				    }
				   prevNode.next = insertNode;
				   insertNode.next = currentNode;
		    } else {
		    	insertNode.next = head;
		    	head = insertNode;
		    }
		return head; 
		
	}
	Node findNodeLocationToInsert(Node head, int position, int currentPosition) {
	    if(currentPosition == position) {
	        return head;
	    } else {
	        return findNodeLocationToInsert(head.next, position, ++currentPosition);
	    }
	}
	
	public Node insertNodeAtTheTail(Node head, int data) {
		Node currentNode = head;
		Node newNode = new Node();
		newNode.data = data;
		if(head != null) {
			while(currentNode.next!= null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		} else {
			head = newNode;
		}
		
		return head;
	}
}
