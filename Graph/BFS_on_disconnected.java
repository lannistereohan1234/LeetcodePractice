/*
*
* Problem: BFS on a Disconnected Graph
What if some nodes aren't reachable from node 0? Your current code would miss them!

Input:

n = 6
edges = [[0,1], [0,2], [3,4], [4,5]]
This graph has TWO components:

Component 1:  0—1, 0—2
Component 2:  3—4, 4—5
Starting BFS from 0 only gives 0 1 2. We miss 3, 4, 5!


*
* Modify your BFS to handle disconnected graphs. The trick is super simple:

Wrap your BFS call inside a loop that goes through all n nodes. If a node hasn't been visited yet, start a new BFS from it.

Expected Output:

BFS Traversal: 0 1 2 3 4 5
*
*
✅ Move visited[] outside the BFS method (or make it a class-level field) so it persists across BFS calls
✅ Create a method bfsDisconnected(List<List<Integer>> adj, int n) that:
Loops i from 0 to n-1
If !visited[i], calls BFS starting from i
✅ Test it with the disconnected graph above in main
*
*
*
* The cleanest pattern is to pass visited[] as a parameter to your BFS method:

public static void bfs(int start, List<List<Integer>> adj, boolean[] visited) {
    // ... use the passed-in visited array ...
}
public static void bfsDisconnected(List<List<Integer>> adj, int n) {
    boolean[] visited = new boolean[n];
    System.out.print("BFS Traversal:");
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            bfs(i, adj, visited);
        }
    }
    System.out.println();
}
(Move the System.out.print of nodes inside the inner BFS loop, and remove the header from there.)


*
*
*
* */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_on_disconnected {



    public static void bfs_usual(List<List<Integer>> adj, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }


    public static void bfsDisconnected(List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        System.out.print("BFS Traversal: ");
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs_usual(adj, i, visited);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2},{3,4}, {4,5}};
        int n=6;

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }



        bfsDisconnected(adj, n);

    }
}
