package Unique_Paths_2;
import java.util.*;
public class MySolnUP2 {
    public static void main(String[] args) {
        //int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{0,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return iterate(obstacleGrid, 0, 0, 0);
    }

    private static int iterate(int[][] obstacleGrid,int i,int j, int sum) {
        if (obstacleGrid[i][j] == 1) 
            return 0;
        else if (i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1) 
            return 1;
        else if (i == obstacleGrid.length-1)
            return sum + iterate(obstacleGrid, i, j+1, sum);
        else if (j == obstacleGrid[0].length-1) 
            return sum + iterate(obstacleGrid, i + 1, j, sum);
        else 
            return sum + iterate(obstacleGrid, i+1, j, sum) + iterate(obstacleGrid, i, j+1, sum);
    }
}
