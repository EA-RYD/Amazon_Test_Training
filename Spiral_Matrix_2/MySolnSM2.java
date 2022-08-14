package Spiral_Matrix_2;
import java.util.*;

public class MySolnSM2 {
    /*
     * Given a positive integer n, generate 
     * an n x n matrix filled with elements 
     * from 1 to n2 in spiral order.Given a positive 
     * integer n, generate an n x n matrix filled with elements 
     * from 1 to n2 in spiral order.
     */
    public static void main(String[] args) {
        int n = 20;
        int[][] newm = generateMatrix(n);
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(newm[i][j] + " ");
            }
            System.out.println();
        }
    }

    //100.00% faster, 43% less memory
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int iDirection = 0,jDirection = 1; // 0 none, 1 up/right, 2 down/left

        int i=0,j=0;
        //int center = n / 2;
        while(count <= n * n) {
            matrix[i][j] = count;
            if (jDirection != 0) {
                if (jDirection == 1) {
                    if (j == n - 1 || matrix[i][j+1] != 0) {
                        iDirection = 2;
                        jDirection = 0;
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    if (j == 0 || matrix[i][j-1] != 0) {
                        iDirection = 1;
                        jDirection = 0;
                        i--;
                    } else {
                        j--;
                    }
                }
            } else {
                if (iDirection == 1) {
                    if (i == 0 || matrix[i-1][j] != 0) {
                        iDirection = 0;
                        jDirection = 1;
                        j++;
                    } else {
                        i--;
                    }
                } else {
                    if (i == n-1 || matrix[i+1][j] != 0) {
                        iDirection = 0;
                        jDirection = 2;
                        j--;
                    }  else {
                        i++;
                    }
                }
            }
            count++;
        }

        return matrix;
    }
}
