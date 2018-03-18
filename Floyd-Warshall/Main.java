// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Floyd Warshall Graph Algorithm
// Date Modified: 5/12/2016
// Main.java
/* A Floyd-Warshall graph algorithm implementation.  */
// Status: working/tested


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String str = "";
        String filename = "sampleInput.txt";
        try {
            Scanner scan = new Scanner(new File(filename));
        //Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine())
            str += scan.nextLine() + " ";
        scan.close();
        } catch (FileNotFoundException fnf) {
            System.err.println("**ERROR**: The file \'" + filename + "\' was not found.");
        }
        str = str.replace(",", " "); // remove commas
        str = str.replaceAll("\\s+", " "); // remove double spaces
        String[] strArr = str.split(" "); // separate integers
        int[] arr = new int[strArr.length];
        for(int i = 0; i < strArr.length;i++)
            arr[i] = Integer.parseInt(strArr[i]);  // convert strings to int[]

        FloydWarshall fw = new FloydWarshall(arr);
        System.out.println(fw);
    }

}
