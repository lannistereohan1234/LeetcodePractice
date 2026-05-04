/*
Given an m x n 2D binary grid where:

'1' = land
'0' = water

An island is a group of '1's connected horizontally or vertically (not diagonally).
Return the number of islands.
*/

public class NumberOfIslands {


    private static void dfs(int[][] grid, int row, int col) {
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]!=1){
            return;
        }

        grid[row][col]=0;     // mark as visited

        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }

    public static int numIslands(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }

        int rows=grid.length;
        int cols=grid[0].length;

        int count=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };



        System.out.println("Number of islands: " + numIslands(grid)); // 3
    }
}
