package graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first, second;
    public Pair(int f, int s){
        first = f;
        second = s;
    }
}
public class NumberOfIsland {
    private void bfs(int row, int col, int visited[][], char[][] grid){
        visited[row][col]=1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            for(int delrow= -1; delrow<=1; delrow++){
                for (int delcol=-1; delcol <= 1; delcol++) {
                    int nrow = r +delrow;
                    int ncol = c +delcol;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' &&
                    visited[nrow][ncol]==0){
                        visited[nrow][ncol] =1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
    public int numberOfIsland(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int islands = 0;
        for (int row = 0; row< n; row++) {
            for (int col = 0; col < m; col++) {
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    islands++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return islands;
    }
}
