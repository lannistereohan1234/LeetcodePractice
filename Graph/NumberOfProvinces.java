/*
*
There are n cities. Some are connected directly, and some are connected indirectly (through other cities).

A province is a group of directly or indirectly connected cities, with no other cities outside the group.

You're given an n x n matrix isConnected where:

isConnected[i][j] = 1 means city i and city j are directly connected
isConnected[i][j] = 0 means they are not
Return the total number of provinces.
*
*
Input:
isConnected = [[1,1,0],
               [1,1,0],
               [0,0,1]]

Output: 2
*
*
*
*
*
* */


import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void dfs_of_province(List<List<Integer>> adj, int node, boolean[] visited) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs_of_province(adj, neighbor, visited);
            }
        }
    }


    public static void main(String[] args) {
        int[][] isConnected =

                {{1, 0, 0, 1},
                        {0, 1, 1, 0},
                        {0, 1, 1, 1},
                        {1, 0, 1, 1}};

        int n = isConnected.length;


        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs_of_province(adj, i, visited);
                count++;
            }
        }

        System.out.println(count);
    }
}
