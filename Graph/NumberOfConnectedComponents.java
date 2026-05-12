import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        // first convert adj matrix to list
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i< n;i++){
            adj.add(new ArrayList<>());
        }

        // no matter how many edges or nodes, these two lines will create adj list of all in undirected graph
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // 2. Initialize visited array and counter

        boolean []visited=new boolean[n];

        int counter=0;

        // 3. For each node, if not visited, run DFS and increment count
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(adj, visited, i);
                counter++;
            }
        }

        return counter;

    }


    // node is the point from where dfs is to be started
    public void dfs(List<List<Integer>> adj, boolean[] visited, int node){
        visited[node]=true;
        for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
                dfs(adj, visited, neighbor);
            }
        }
    }


    public static void main(String[] args) {
        NumberOfConnectedComponents gc = new NumberOfConnectedComponents();
        int n = 5;
        int[][] edges = {{0, 1}, {2, 3}, {3, 4}};
        System.out.println("Number of components: " + gc.countComponents(n, edges));
    }
}
