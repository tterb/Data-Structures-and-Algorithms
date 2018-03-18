// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Floyd Warshall Graph Algorithm
// Date Modified: 5/12/2016
// FloydWarshall.java 
/* This class features an implementation of Floyd-Warshall's Algorithm, which
 * uses dynamic programming to find the shortest path between all pairs of
 * vertices in a graph and returns the information as distance and parent
 * matrices.                                                                                                           */


public class FloydWarshall {

    private int n;
    private double[][][] dist;
    private double[][] parent;
    private double inf = Double.POSITIVE_INFINITY;


    public FloydWarshall(int[] arr) {
        n = max(arr);  // max value = # of vertices
        dist = new double[n + 1][n + 1][n + 1];  // distance matrices
        parent = new double[n + 1][n + 1];   // parent matrix

        for(int i = 1; i <= n; i++)  // initialize matrices
            for(int j = 1; j <= n; j++) {
                if (i != j) {
                    dist[0][i][j] = inf;
                    parent[i][j] = inf;
                } else {
                    dist[0][i][j] = 0;
                    parent[i][j] = i;
                }
            }

        for(int i = 0; i < arr.length;i++) {    // input values into the matrices
            if (i % 3 == 0) {
                dist[0][arr[i++]][arr[i++]] = (double) arr[i];
                parent[arr[i-2]][arr[i-1]] = arr[i-2];
            }
        }

        for(int i = 1; i <= n; i++)   // check for self-loops
             if(dist[0][i][i] > 0)
                dist[0][i][i] = 0;

        for(int k = 1; k <= n; k++)
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++) {
                    if (dist[k - 1][i][j] > dist[k - 1][i][k] + dist[k - 1][k][j]) {
                        dist[k][i][j] = dist[k - 1][i][k] + dist[k - 1][k][j];
                        parent[i][j] = k;
                    } else
                        dist[k][i][j] = dist[k - 1][i][j];
                }
    }


    private int max(int[] arr) {  // returns max value
        int max = arr[0];
        for(int i = 0; i < arr.length; i++)
        if(i % 3 != 2 && max < arr[i])
            max = arr[i];
        return max;
    }


    public String toString() {  // formats and prints distance & parent matrices
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%11s %"+(3*n+6)+"s %n", "Distance:", "Parent:"));
        for(int k = 0; k <= n; k++) {
            for(int j = 0; j < 2; j++) {
                if (k > 0)
                    sb.append(String.format("%3d", k)); // right indexes
                for(int i = 0; i <= n; i++) {
                    if (k == 0 && i == 0)
                        sb.append(String.format("%3s", " "));
                    else if (k == 0)
                        sb.append(String.format("%3d", i));  // top indexes
                    else if (i > 0)
                        if (j == 0)
                            if (dist[n][k][i] != inf)
                                sb.append(String.format("%3d", (int) dist[n][k][i]));
                            else
                                sb.append(String.format("%3c", '.'));
                        else if (parent[k][i] != inf)
                            sb.append(String.format("%3d", (int) parent[k][i]));
                        else
                            sb.append(String.format("%3c", '.'));
                }
                sb.append("\t\t ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


//    private void printMatrix(double[][] matrix) {
//        System.out.print("   ");
//        for(int k = 1; k <= n; k++) {
//            System.out.print(String.format("%3d", k));
//        }
//        System.out.println();
//        for(int i = 1; i <= n; i++) {
//            System.out.print(String.format("%3d", i));
//            for(int j = 1; j <= n; j++) {
//                if(matrix[i][j] != inf)
//                    System.out.print(String.format("%3d", (int) matrix[i][j]));
//                else
//                    System.out.print(String.format("%3c", '-'));
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
