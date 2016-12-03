// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Main.java
// Status: working/tested


import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Stack s = new Stack();
		try{
			Scanner scan = new Scanner(System.in);
			double newData;
			while(scan.hasNextLine()) {    // what to do when next line is a non-double?
			 	newData = scan.nextDouble();
				s.push(newData);
			}
		} catch (InputMismatchException ime) {
			System.out.println("**Error**: " + ime);
		}

		while(!s.isEmpty()) 		
			System.out.printf("%1$.2f\n", s.pop());
	}

}
