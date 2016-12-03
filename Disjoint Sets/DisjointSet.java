// Brett Stevenson
// Email: therealbrettstevenson@gmail.com
// Account: bstevens
// Date Modified: 04/20/2016
// DisjointSet.java (v1.4)
/* This class features an implementation of a Union-Find data structure, where
 * each element represents a single square in the generated maze. This is used
 * to link adjacent sets until all of individual squares are joined within a
 * single set.                                                                */
// Status: working/tested


public class DisjointSet {

    private int size;
    private int[] parent;
    private int[] rank;

    public DisjointSet(int n) {
        size = (int) Math.pow(n, 2);
        parent = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public void union(int x, int y) {  // public wrapper function for joining indexes
        if(x < size && x >= 0 && y < size && y >= 0)   // bounds check
            link(find(x), find(y));
    }

    private void link(int x, int y) {  // links the two adjacent squares depending on their rank
        if(rank[x] > rank[y])
            parent[y] = x;
        else {
            parent[x] = y;
            if (rank[x] == rank[y])
                rank[y] += 1;    // rank only changes on tie
        }
    }

    public int find(int x) {
        if(x < size && x >= 0)   // bounds check
            return findThis(x);
        return -1;
    }

    private int findThis(int x) {
        if(x != parent[x])
            parent[x] = findThis(parent[x]);
        return parent[x];
    }

    public boolean isComplete() {   // returns true if all elements are in a single set
        for(int i = 0; i < parent.length-1; i++)
            if(find(i) != find(i + 1))
                return false;
        return true;
    }

}
