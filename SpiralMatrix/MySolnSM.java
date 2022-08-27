package SpiralMatrix;
import java.util.*;

public class MySolnSM {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralOrder(matrix);
        for (Integer integer : list) {
            System.out.print(integer);
        }
        System.out.println();
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int count = 1;
        int m = matrix.length,n = matrix[0].length;
        int iDirection = 0,jDirection = 1; // 0 none, 1 up/right, 2 down/left

        int i=0,j=0;
        //int center = n / 2;
        while(count <= m * n) {
            list.add(matrix[i][j]);
            matrix[i][j] = 0;
            if (jDirection != 0) {
                if (jDirection == 1) {
                    if (j == n - 1 || matrix[i][j+1] == 0) {
                        iDirection = 2;
                        jDirection = 0;
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    if (j == 0 || matrix[i][j-1] == 0) {
                        iDirection = 1;
                        jDirection = 0;
                        i--;
                    } else {
                        j--;
                    }
                }
            } else {
                if (iDirection == 1) {
                    if (i == 0 || matrix[i-1][j] == 0) {
                        iDirection = 0;
                        jDirection = 1;
                        j++;
                    } else {
                        i--;
                    }
                } else {
                    if (i == m-1 || matrix[i+1][j] == 0) {
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

        return list;
    }
}
