// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Radix/Bucket sort
// Date Modified: 03/17/2016
// RadBucket.java 
/*  This class implements a radix/bucket hybrid sorting algorithm, which sorts each input integer
    value from the least to the most significant digit, and features O(n) performance. This program
    reads it's input from STDIN and prints the sorted data, one per line to STDOUT. */
// Status: working/tested


import java.util.Scanner;
import java.util.ArrayList;


public class RadBucket {

    public static void main(String[] args) {
        int d = 9;   // # of digits
        int k = 10;  // integer range (0-9)
        ArrayList<Integer> list = new ArrayList<Integer>();  // stores user input

	Scanner scan = new Scanner(System.in);
	while(scan.hasNextInt())
	    list.add(scan.nextInt());

        list = radBucket(list, d, k);

	for(int val : list)
	    System.out.printf("%09d\n", val);  // restores zero-padded format & prints
    }


    private static ArrayList<Integer> radBucket(ArrayList<Integer> list, int d, int k) {
        for(int pos = 1; pos <= d; pos++) {  // iterates through each place value
            int[] arr = new int[list.size()];  
            for(int i = 0; i < list.size(); i++)   // extracts & stores the integers from the target place value
                arr[i] = list.get(i) % (int) Math.pow(10, pos) / (int) Math.pow(10, pos - 1); 

            ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i <= k; i++)
                buckets.add(new ArrayList<Integer>());  // create a bucket for each place value

            for(int i = 0; i < arr.length; i++)
                buckets.get(arr[i]).add(list.get(i));  // place extracted values into ordered buckets

            list.clear();
            for(int i = 0; i <= k; i++)
                for(int val : buckets.get(i))   // concatenate buckets
                    list.add(val);
        }
        return list; // returns fully sorted ArrayList
    }

}
