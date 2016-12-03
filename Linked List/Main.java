// CS-21: Assignment #1
// p1.java
//
//

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		System.out.println("Linked List");
		list.insertFront(0.1);
		list.insertRear(1.25);
		list.insertRear(2.0);
		list.insertRear(3.0);
		list.insertRear(4.0);
		list.insertRear(5.0);
		list.insertRear(6.66);
		list.insertRear(7.25);
		list.insertRear(8.75);
		list.insertRear(9.10);
		list.insertRear(0.58976);
		list.deleteFront();
		list.deleteRear();
		list.printAll();
		list.clear(); 		// function not necessary
		list.printAll();
		
		Stack s = new Stack();
		s.push(0.0);
		s.push(1.1);
		s.push(2.0);
		s.push(3.0);
		s.push(4.4);
		s.push(5.5);
		s.push(6.0);
		s.push(7.0);
		s.push(8.00);
		s.push(9.0);
		s.printStack();
		while(!s.isEmpty()) 
			System.out.println(s.pop());
		s.printStack();
	}
}
