package Number_of_Distinct_Islands_identical;
import java.util.*;

public class MySolnDI {
    public static void main(String[] args) {
        
    }

    public int numDistinctIslands(int[][] grid){ 
        // hashset of sets of indice sets integers
        HashSet<List<List<Integer>>> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    //drownIsland(set, i, j,grid);
                }
            }
        }


        return set.size();
    }

    public void drownIsland(List<List<Integer>> set, int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] != 1) {
            return;
        } else {
            grid[i][j] = 0;
            drownIsland(set, i+1, j, grid);
            drownIsland(set, i, j+1, grid);
            drownIsland(set, i-1, j, grid);
            drownIsland(set, i, j-1, grid);
        }
    }
}
