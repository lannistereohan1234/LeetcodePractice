/*
*
*
* Problem: DFS Traversal of a Graph (handles disconnected too!)
Given an undirected graph (possibly disconnected), return the DFS traversal starting from each unvisited node.

Test Case 1 (connected):
n = 5
edges = [[0,1], [0,2], [1,3], [3,4], [2,4]]
Expected: DFS Traversal: 0 1 3 4 2
Test Case 2 (disconnected):
n = 6
edges = [[0,1], [0,2], [3,4], [4,5]]
Expected: DFS Traversal: 0 1 2 3 4 5


*
The DFS method should look almost identical in structure to your BFS method, just recursive instead of using a queue
Mark visited at the START of dfs, before printing
The dfsTraversal outer loop is identical to bfsDisconnected — just call dfs instead
*
*
*
*
*
*
*
* */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DFS {

    public static void dfs(List<List<Integer>> adj,  int start, boolean []visited){
//        Deque<Integer> stack = new ArrayDeque<>();
//        stack.push(start);
//        while (!stack.isEmpty()) {
//            int node = stack.pop();
//            if (visited[node]) continue;
//            visited[node] = true;
//            System.out.print(node + " ");
//            for (int neighbor : adj.get(node)) {
//                if (!visited[neighbor]) {
//                    stack.push(neighbor);
//                }
//            }
//        }

        visited[start] = true;
        System.out.print(start+ " ");

        for(int neighbor: adj.get(start)){
            if(!visited[neighbor]){
                dfs(adj,neighbor,visited);  // recursive call
            }
        }

    }


    public static void dfs_disconnected(List<List<Integer>> adj, int n){
        boolean[] visited = new boolean[n];
        System.out.print("DFS Traversal: ");
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited);
            }
        }

    }

    public static void main(String[] args) {
        // Test Case 1: Disconnected Graph
        System.out.println("Test Case 1 (disconnected graph):");
        int[][] edges = {{0,1}, {0,2}, {3,4}, {4,5}};
        int n = 6;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfs_disconnected(adj, n);
        System.out.println();

        // Test Case 2: Connected Graph
        System.out.println("Test Case 2 (connected graph):");
        int[][] connectedEdges = {{0,1}, {0,2}, {1,3}, {3,4}, {2,4}};
        int connectedN = 5;

        List<List<Integer>> connectedAdj = new ArrayList<>();
        for (int i = 0; i < connectedN; i++) {
            connectedAdj.add(new ArrayList<>());
        }

        for (int[] edge : connectedEdges) {
            connectedAdj.get(edge[0]).add(edge[1]);
            connectedAdj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[connectedN];
        System.out.print("DFS Traversal: ");
        dfs(connectedAdj, 0, visited);
        System.out.println();
    }
}
