package Treasure_Island;
import java.util.*;

public class MySolnTI {
    /*
     * You have a map that marks the location of a treasure island. 
     * Some of the map area has jagged rocks and dangerous reefs. 
     * Other areas are safe to sail in. There are other explorers 
     * trying to find the treasure. So you must figure out a shortest route to the treasure island.

Assume the map area is a two dimensional grid, represented by a matrix of characters. 
You must start from the top-left corner of the map and can move one block up, down, left or right at a time. 
The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner. 
Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. 
You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe. 
Output the minimum number of steps to get to the treasure
     */
    public static void main(String[] args) {
        //int[][] grid = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        char[][] grid = {{'O','O','O','O'},{'D','O','D','O'},{'O','O','O','O'},{'X','D','D','O'}};
        System.out.println(minSteps(grid));
    }

    //soln is BFS, breath first solution
    // usually do that with que
    public static int minSteps(char[][] grid) { 
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {0,0});
        grid[0][0] = 'D'; // mark as dont go, (dont visit already visited)
        int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}}; //left,right,up,down

        int path = 1;
        while(!que.isEmpty()) {
            for (int size = que.size();size>0;size--) {
                int[] point = que.poll();
                
                for (int i = 0;i<directions.length;i++) { //four directions
                    int x = point[0] + directions[i][0];
                    int y = point[1] + directions[i][1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 'D') {
                        if (grid[x][y] == 'X') return path;
                        grid[x][y] = 'D';
                        que.add(new int[] {x,y});
                    }
                }
            }
            path++;
        }

        return -1;
    }
}
