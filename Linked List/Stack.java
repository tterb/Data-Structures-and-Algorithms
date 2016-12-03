// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Stack.java
// Status: working/tested


public class Stack extends LinkedList {

	LinkedList list = new LinkedList();

	public void push(double newData) {
		list.insertFront(newData);
	}

	public double pop() {
		while(!list.isEmpty()){
			//System.out.println("im not empty!");
			double temp = list.head.data;
			list.deleteFront();
			return temp;
		} 
		System.err.println("Warning: pop on empty stack, returning -1");
		return -1;
	}

	public boolean isFull(){ return false;}

	public boolean isEmpty() { 
		if(list.isEmpty()) 
			return true; 
		return false;
	}

	public void printStack(){
		System.out.println("");
		list.printAll();
	}

}
