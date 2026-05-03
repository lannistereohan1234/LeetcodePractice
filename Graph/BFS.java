
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


    public static void bfs(List<List<Integer>> adj, boolean []visited, int start){
        Queue<Integer> queue=new LinkedList<>();

        queue.offer(start);     //add start node
        visited[start]=true;        // mark visited

        System.out.print("BFS Traversal:");

        while(!queue.isEmpty()){            // queue is not empty now, so loop runs
            int node= queue.poll();         // check the current node
            System.out.print(" " + node);

            for(int neighbor: adj.get(node)){               // get neighbors for current node
                if(!visited[neighbor]) {                    // as they aren't visited

                    visited[neighbor] = true;                  // mark them visited
                    queue.offer(neighbor);                      // add to queue
                }
            }
        }

        System.out.println();
    }



    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2}, {1,3},{3,4}, {2,4}};
        int n=5;


        List<List<Integer>> adj=new ArrayList<>();
        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }


        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }



        bfs(adj, visited, 0);
    }
}
