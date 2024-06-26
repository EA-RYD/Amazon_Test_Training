package Min_Path_Sum;
import java.util.*;

/*
 * 
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right, which minimizes 
 * the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
 */

public class MySolnMPS {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    /*
     * It is simply that we store or cache the results of every single calculation so that 
     * we don't need to calculate the same thing again and again. 
     *  We just involve an array to store 
     * the values. 
     * 
     * each value in array becomes sum of lowest path to it
     */
    public static int minPathSum(int[][] grid) {

        int height = grid.length;
        int width = grid[0].length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if(row == 0 && col == 0) grid[row][col] = grid[row][col];
                else if(row == 0 && col != 0) grid[row][col] = grid[row][col] + grid[row][col - 1];
                else if(col == 0 && row != 0) grid[row][col] = grid[row][col] + grid[row - 1][col];
                else grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        return grid[height - 1][width - 1];
    }
}
