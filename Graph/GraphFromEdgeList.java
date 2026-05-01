import java.util.ArrayList;
import java.util.List;

public class GraphFromEdgeList {


    public static void print(int [][] edges, int n){
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,3},{3,4},{2,4}};

        print(edges, 5);
    }
}
