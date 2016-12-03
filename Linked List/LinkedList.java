// CS-21: Assignment #1
// LinkedList.java
// Implements a Doubly Linked List data structure and inner LinkNode class which handles doubles.
//

public class LinkedList {

	protected LinkNode head;
	protected LinkNode tail;

	public LinkedList() { head = tail = null;}

	public boolean isEmpty() { return head == null; }

	public void insertFront(double newData) {
		LinkNode temp = new LinkNode();
		temp.data = newData;
		if(isEmpty()) {
			head = tail = temp;
			return;
		}
		head.prev = temp;
		temp.next = head;
		head = temp;
	}

	public void insertRear(double newData) {
		if(isEmpty())
			insertFront(newData);
		LinkNode temp = new LinkNode(newData);
		tail.next = temp;
		temp.prev = tail;
		tail = temp;
	}

	public void deleteFront() {
		if(isEmpty())
			return;
		else if (head == tail) {
			head = tail = null;
			return;
		}
		head.next.prev = null;
		head = head.next;
	}

	public void deleteRear() {
		if(isEmpty())
			return;
		else if (head == tail) {
			head = tail = null;
			return;	
		}
		tail.prev.next = null;
		tail = tail.prev;
	}

	public void clear() {
		if(isEmpty())
			return;
		while(head != null)
			deleteRear();
	}

	public void printAll() {
		LinkNode temp = head;
		if(head == null)
			System.out.println("The list is empty!");
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	protected class LinkNode {

		protected LinkNode next;
		protected LinkNode prev;
		protected double data;

		public LinkNode() { 
			next = prev = null; 
			data = 0.0; 
		}

		public LinkNode(double newData) {
			next = prev = null;
			data = newData;
		}

	}
}
