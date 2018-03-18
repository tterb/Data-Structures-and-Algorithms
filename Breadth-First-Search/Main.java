// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Date Modified: 05/5/2016
// Main.java
/* This class features the main method of the Breadth First Search program,
 * which reads a hexadecimal maze from STDIN and returns the shortest path
 * through the maze, step-by-step as a set of coordinates to STDOUT.       */
// Status: working/testing


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String hex = "";
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext())
        hex += scan.next().toLowerCase();

        int size = hex.length();
        int n = (int) Math.sqrt(size);
        int[] maze = new int[size];
        String[] hexMaze = hex.split("");
        for(int i = size; i > 0; i--) {    // Due to discussed issue with String.split()
 	if (hexMaze[i].length() > 0 && (int) hexMaze[i].charAt(0) - 87 >= 10)   // is a lowercase char
	   maze[i-1] = (int) hexMaze[i].charAt(0) - 87;
            else
                maze[i-1] = Integer.parseInt(hexMaze[i]);
        }
        BFS bfs = new BFS(maze, 0);
        System.out.println(bfs);
    }
}
