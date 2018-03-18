// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Date Modified: 04/20/2016
// MazeGen.java (v1.4)
/* This class is responsible for initializing, storing, and modifying the
 * values(shapes) of the individual squares as they merge within the Union-Find
 * data structure to generate a continuous maze.                                */
// Status: working/tested


/* Shapes:
*     Right: 1,3,5,7,9,11,13,15 (i % 2 = 1)
*     Left: 4,5,6,7,12,13,14,15 (i >= 4 && i < 8) && (i > 12 && i < 16)
*     Top: 8,9,10,11,12,13,14,15 (i >= 8 && i < 16)
*     Bottom: 2,3,6,7,10,11,14,15 (i,i+1,i+3...
*/

import java.util.Random;


public class MazeGen {

    private int n;
    private int size;
    private int[] arr;

    public MazeGen(int n) {
        this.n = n;
        size = (int) Math.pow(n, 2);
        arr = new int[size];
        initializeMaze();
    }

    private void initializeMaze() { // initialize maze values
        for(int i = 0; i < size; i++)
            if(i == 0)
                arr[i] = 11;
            else if(i == size - 1)
                arr[i] = 14;
            else
                arr[i] = 15;
    }

    private int above(int i) { return i - n; } // returns above index
    private int left(int i) { return i - 1; }  // returns left index
    private int right(int i) { return i + 1; } // returns right index
    private int below(int i) { return i + n; } // returns below index

    private boolean hasTop(int i) { return i > 7; }                     // TODO: keep helpers?
    private boolean hasLeft(int i) { return i > 11 || i > 3 && i < 8; }
    private boolean hasRight(int i) { return i % 2 == 1; }
    private boolean hasBottom(int i) { return i % 4 >= 2; }


    public void linkMaze(int x, int y) {
        if(x < 0 || x >= size || y < 0 || y >= size) return;  // bounds check
//        if(y == right(x) && arr[x] % 2 == 1) {
//            if(arr[y] > 11 || arr[y] > 3 && arr[y] < 8) {
//                arr[x] = arr[x] - 1;  // x has right
//                arr[y] = arr[y] - 4;  // y has left
//            }
//    } else if(y == below(x)) {
//        if(arr[x] % 4 >= 2 && arr[y] > 7) { // TODO: check logic on these
//            arr[x] = arr[x] - 2;  // x has bottom
//            arr[y] = arr[y] - 8;  // y has top
//        }
//    } else if(y == left(x) && arr[y] % 2 == 1) {
//        if(arr[x] > 11 || arr[x] > 3 && arr[x] < 8) {
//            arr[x] = arr[x] - 4;  // x has left
//            arr[y] = arr[y] - 1;  // y has right
//        }
//    } else {
//        if(arr[x] > 7 && arr[y] % 4 >= 2) {
//            arr[x] = arr[x] - 8;  // x has top
//            arr[y] = arr[y] - 2;  // y has bottom
//        }
//    }
        if(y == right(x)) {
            if(hasRight(arr[x]) && hasLeft(arr[y])) {
                arr[x] = arr[x] - 1;
                arr[y] = arr[y] - 4;
            }
        } else if(y == below(x)) {
            if(hasBottom(arr[x]) && hasTop(arr[y])) {
                arr[x] = arr[x] - 2;
                arr[y] = arr[y] - 8;
            }
        } else if(y == left(x)) {
            if(hasLeft(arr[x]) && hasRight(arr[y])) {
                arr[x] = arr[x] - 4;
                arr[y] = arr[y] - 1;
            }
        } else {
            if(hasTop(arr[x]) && hasBottom(arr[y])) {
                arr[x] = arr[x] - 8;
                arr[y] = arr[y] - 2;
            }
        }
    }


    public int adjacent(int x) {  // randomly gets an adjacent index
        Random rndm = new Random();
        if (x >= size || x < 0) return x;  // bounds check
        int y = -1;
        while (y < 0) {
           int val = rndm.nextInt(4);
            if (val == 0 && x % n != (n - 1))
                y = right(x);
            else if (val == 1 && x < n * (n - 1))
                y = below(x);
            else if (val == 2 && x % n != 0)
                y = left(x);
            else if (val == 3 && x % n != x)
                y = above(x);
        }
        return y;
    }


    public int[] shuffle() {  // returns an array of shuffled indexes
        Random rndm = new Random();
        int[] index = new int[size];
        int temp; int swap;
        for(int i = 0; i < index.length; i++)
            index[i] = i;
        for (int i = size-1; i >= 0 ; i--){
            swap = rndm.nextInt(size);
            temp = index[i];
            index[i] = index[swap];
            index[swap] = temp;
        }
        return index;
    }

    public String toString() {  // Overrides toString() method to properly print the generated maze
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(i % n == 0 && i > 0 && i != n*n)
                sb.append("\n");
            if(arr[i] < 10)
                sb.append(arr[i]);
            else   // convert to Hex
                sb.append(Integer.toHexString(arr[i]));
        }
        return sb.toString();
    }

}
