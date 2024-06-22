package graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {

    }

    public static List<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        visited[0] = true;
        List<Integer> list = new ArrayList<>();
       dfs(0, visited, adj, list);
       return list;
    }

    private static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, List<Integer> list) {
        visited[node] = true;
        list.add(node);

        //visit the neighbors fo that node and call DFS recursively
        for (Integer neighbor : adj.get(node)) {
            if(visited[neighbor]==false){
                dfs(neighbor, visited, adj, list);
            }
        }
    }
}
