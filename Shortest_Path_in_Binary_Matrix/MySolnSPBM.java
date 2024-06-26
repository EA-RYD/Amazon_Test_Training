package Shortest_Path_in_Binary_Matrix;
import java.util.*;

public class MySolnSPBM {
    /*
     * Given an n x n binary matrix grid, return the length of the 
     * shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell 
(i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., 
    they are different and they share an edge or a corner).

The length of a clear path is the number of visited cells of this path.
     */
    public static void main(String[] args) {
        int[][] grid = {
        {0,0,0},
        {0,0,0},
        {0,0,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }


    //shortest path so breath first
    //change nums t 
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int directions[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] != 0 || grid[n-1][m-1] != 0) {return -1;}
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0,0}); 
        grid[0][0] = 1;   
        int ans = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] cell = que.poll();
                if (cell[0] == n-1 && cell[1] == m-1) { //reach end or about to so return +1
                    return ans+1;
                }
                for (int j = 0; j < 8; j++) { //check each direction
                    int nextX = directions[j][0]+cell[0];
                    int nextY = directions[j][1]+cell[1];

                    if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && grid[nextX][nextY]==0) {
                        grid[nextX][nextY] = 1;
                        que.offer(new int[]{nextX,nextY});
                    }
                }
            }
            ans++;
        }
        return -1;
    }

}
