
/*
*
*
BFS Traversal of a Graph
Given an undirected graph, return the BFS traversal starting from node 0.

Input:

n = 5
edges = [[0,1], [0,2], [1,3], [3,4], [2,4]]
Expected Output:


BFS Traversal: 0 1 2 3 4
*
*
*
*
* */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {


    public static void bfs(List<List<Integer>> adj, int n, int start){
        Queue<Integer> queue=new LinkedList<>();

        boolean[] visited=new boolean[n];

        queue.offer(start);
        visited[start]=true;

        System.out.print("BFS Traversal:");

        while(!queue.isEmpty()){
            int node= queue.poll();
            System.out.print(" " + node);

            for(int neighbor: adj.get(node)){
                if(!visited[neighbor]) {

                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println();
    }



    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2}, {1,3},{3,4}, {2,4}};
        int n=5;

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }


        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }


        bfs(adj, n, 0);
    }
}
