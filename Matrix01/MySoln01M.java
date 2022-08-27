package Matrix01;
import java.util.*;

public class MySoln01M {
    /*
     * 
     * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
     */
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        updateMatrix(mat);
        for (int[] m: mat) {
            for (int i : m) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    //idea: iterate through array and mark down zero locations and then use bfs at each zero location
    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) 
                    que.add(new int[] {i,j});
                else 
                    mat[i][j] = -1; //unreached point (1)
            }
        }

        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while (!que.isEmpty()) {
            int[] cell = que.poll();
            for (int[] d : dir) {
                int newI = cell[0] + d[0];
                int newJ = cell[1] + d[1];
                if (newI < 0 || newI >= mat.length || newJ < 0 || newJ >= mat[0].length || 
                    mat[newI][newJ] != -1) continue;
                que.add(new int[] {newI, newJ});
                mat[newI][newJ] = mat[cell[0]][cell[1]] + 1;
            }

        }
        return mat;
    }
}
