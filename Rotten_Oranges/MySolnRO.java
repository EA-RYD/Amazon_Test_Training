package Rotten_Oranges;

import java.util.*;

public class MySolnRO {
    public static void main(String[] args) {
        //int[][] grid = new int[][] {{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid = new int[][] {{0,2}};
        System.out.println(orangesRotting(grid));

        
    }


    // faster than 76.90, memory better than 42
    // check if any clean at start and log locations
    public static int orangesRotting(int[][] grid) {
        Queue<List<Integer>> orangeSpreaders = new LinkedList<>();
        int cleanTotal = 0;
        
        for (int i = 0; i < grid.length; i++) 
            for (int j = 0; j < grid[0].length; j++) 
                if (grid[i][j] == 2) 
                    orangeSpreaders.add(new ArrayList<>(Arrays.asList(i,j)));
                else if (grid[i][j] == 1)
                    cleanTotal++; 
    
        if (cleanTotal == 0) 
            return 0;

        int minutes = 0;
        List<List<Integer>> tempHolder = new ArrayList<>();
        while (!orangeSpreaders.isEmpty()) {
            List<Integer> temp = orangeSpreaders.poll();
            int i = temp.get(0), j = temp.get(1);

            cleanTotal -= spreader(grid, i-1, j, tempHolder);
            cleanTotal -= spreader(grid, i+1, j, tempHolder);
            cleanTotal -= spreader(grid, i, j-1, tempHolder);
            cleanTotal -= spreader(grid, i, j+1, tempHolder);

            if (orangeSpreaders.isEmpty() && !tempHolder.isEmpty()) {
                for (List<Integer> orange : tempHolder) {
                    orangeSpreaders.add(orange);
                }
                tempHolder.clear();
                minutes++;
            }
        }

        if (cleanTotal != 0) 
            return -1; 
        
        return minutes;
    }

    private static int spreader(int[][] grid,int i,int j, List<List<Integer>> temp) {
        if (i > grid.length-1 || i < 0 || j > grid[0].length-1 || j < 0 || grid[i][j] == 0 || grid[i][j] == 2) {
            return 0;
        } else {
            grid[i][j] = 2;
            temp.add(new ArrayList<>(Arrays.asList(i,j)));
            return 1;
        }
    }

    
}
