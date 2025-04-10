package arrays_strings.twoD_array;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    // Question
    /*
     * You are given an m x n grid where each cell can have one of three values:
     * 
     * 0 representing an empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
     * orange becomes rotten.
     * 
     * Return the minimum number of minutes that must elapse until no cell has a
     * fresh orange. If this is impossible, return -1.
     * 
     * Example 1:
     * 
     * 
     * Input: grid = [[2,1,1],
     * [1,1,0],
     * [0,1,1]]
     * Output: 4
     */

    public static void main(String[] args) {
        int oranges[][] = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println("How many oranges rotten? " + rottenOranges(oranges));
    }

    public static int rottenOranges(int oranges[][]) {
        // This is solved using BFS approach
        // you need queue and visited array in BFS
        int rowLength = oranges.length;
        int colLength = oranges[0].length;
        int freshCount = 0;
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (oranges[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (oranges[i][j] == 1)
                    freshCount++;
            }
        }
        int maxtime = 0;
        // how to calculate adjacent cells row and colums values
        //               (row-1,col)
        //                    |
        // (row,col-1) -- (row,col) -- (row,col+1)
        //                    |
        //               (row+1,col)

        int adjacentRow[] = { -1, 0, +1, 0 };
        int adjacentCol[] = { 0, +1, 0, -1 };
        int count = 0;
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            maxtime = Math.max(maxtime, t);
            q.remove();
            // now visit all adjacent nodes of the node removed from queue
            for (int i = 0; i < 4; i++) {
                int nrow = r + adjacentRow[i];
                int ncol = c + adjacentCol[i];
                if (nrow >= 0 && nrow < rowLength
                        && ncol >= 0 && ncol < colLength
                        && vis[nrow][ncol] == 0
                                & oranges[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }
        if (count != freshCount)
            return -1;
        return maxtime;
    }
}

class Pair {
    int row;
    int col;
    int time;

    public Pair(int r, int c, int t) {
        row = r;
        col = c;
        time = t;
    }
}
