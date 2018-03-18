// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Date Modified: 04/20/2016
// Main.java (v1.4)
/* This class contains the main function of the program, which is responsible
 * for both the I/O of the program, as well as facilitating the cooperation
 * between the MazeGen and DisjointSet classes.                               */
// Status: working/tested

public class Main {

    public static void main(String[] args) {
//        if (args.length < 1 || Integer.parseInt(args[0]) < 3) {
//            System.err.println("**ERROR**: You must specify a size (>=3) for the maze");
//            System.exit(0);
//        }
//        n = Integer.parseInt(args[0]);
        int n = 100;
        MazeGen maze = new MazeGen(n);
        DisjointSet set = new DisjointSet(n);
        int[] index = maze.shuffle();

        while(!set.isComplete()) {
            for(int x : index) {
                int y = maze.adjacent(x);
                if(set.find(x) != set.find(y)) {
                    maze.linkMaze(x, y);
                    set.union(x, y);
                }
            }
        }
        System.out.println(maze);
    }

}
