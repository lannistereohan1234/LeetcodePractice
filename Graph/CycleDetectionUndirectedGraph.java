/*
*
* Cycle Detection — Part 1 (Undirected Graphs)
*
*
* A cycle is a path that starts and ends at the same node, using at least one edge.

Visual Examples:
Has cycle (undirected):       No cycle (undirected, a tree):

    0 — 1                            0
    |   |                           / \
    3 — 2                          1   2
                                      / \
   0→1→2→3→0 ✓                       3   4
🌟 Critical Insight:
An undirected graph without cycles is called a TREE (if connected) or a FOREST (if disconnected).

This is why "is this graph a tree?" problems = "no cycles + connected".

🧠 The Core Intuition for Undirected Cycle Detection
The Naive (and WRONG) idea:
"If I do DFS and see a node that's already visited, it's a cycle."

❌ This is WRONG for undirected graphs! Why?

Consider this simple graph: 0 — 1

When DFS goes from 0 to 1, then from 1 it sees 0 (its only neighbor). 0 is already visited! Are we in a cycle?

NO! We just came from 0. Going back to where we came from is NOT a cycle.

✅ The CORRECT idea:
A visited neighbor causes a cycle ONLY IF that neighbor is NOT the parent (the node we came from).

So in DFS, we must track the parent of each call.
*
*
*
*
The Undirected Cycle Detection Template (DFS)

public static boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
    visited[node] = true;
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            if (dfs(neighbor, node, adj, visited)) return true;
        } else if (neighbor != parent) {
            return true;  // ← visited AND not parent = CYCLE!
        }
    }
    return false;
}

Calling it (handles disconnected too!):

public static boolean hasCycle(int n, List<List<Integer>> adj) {
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            if (dfs(i, -1, adj, visited)) return true;  // -1 = no parent for root
        }
    }
    return false;
}
*
*
*
The "Parent Trick" — Why This Pattern is Special
This is the FIRST time we've used a parent parameter in DFS. This pattern shows up in:

Cycle detection (undirected) ← here
Tree problems where you walk up
Some graph coloring problems
Memorize this template — you'll use it again!


*
*
*
*
Problem: Detect Cycle in an Undirected Graph
Given an undirected graph with n nodes and an edge list, return true if the graph contains a cycle.

Test Cases:

Test 1: HAS cycle
n = 4
edges = [[0,1], [1,2], [2,3], [3,0]]
Expected: true
Test 2: NO cycle (tree)
n = 4
edges = [[0,1], [0,2], [0,3]]
Expected: false
Test 3: Disconnected with cycle in one component
n = 6
edges = [[0,1], [2,3], [3,4], [4,2]]
Expected: true   (component 2-3-4 has cycle)
Test 4: Single edge (no cycle)
n = 2
edges = [[0,1]]
Expected: false
*
* */


import java.util.ArrayList;
import java.util.List;

public class CycleDetectionUndirectedGraph {
    public static boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited){
        visited[node]=true;
       for(int neighbour: adj.get(node)){
           if(!visited[neighbour]){
               if(dfs(neighbour, node, adj,visited))    return true;
           }else if(neighbour!=parent){
               return true;  // ← visited AND not parent = CYCLE!
           }
       }

       return false;
    }

    public static boolean hasCycle(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) return true;  // -1 = no parent for root
            }
        }
        return false;
    }

    public static List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{1,2},{2,3},{3,0}};
        System.out.println("Test 1: " + hasCycle(4, buildGraph(4, edges1)));  // true

        int[][] edges2 = {{0,1},{0,2},{0,3}};
        System.out.println("Test 2: " + hasCycle(4, buildGraph(4, edges2)));  // false

        int[][] edges3 = {{0,1},{2,3},{3,4},{4,2}};
        System.out.println("Test 3: " + hasCycle(6, buildGraph(6, edges3)));  // true

        int[][] edges4 = {{0,1}};
        System.out.println("Test 4: " + hasCycle(2, buildGraph(2, edges4)));  // false


    }
}
