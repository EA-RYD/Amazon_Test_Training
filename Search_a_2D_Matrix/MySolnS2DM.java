package Search_a_2D_Matrix;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
 * This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

 */

public class MySolnS2DM {
    public static void main(String[] args) {
        //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1,3}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    // 39.44%
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[i].length-1] > target) {
                return mergeSearch(Arrays.stream(matrix[i]).boxed().collect(Collectors.toList()),target);
            } else if (matrix[i][matrix[i].length-1] == target) {
                return true;
            }
        }

        return false;
    }

    private static boolean mergeSearch(List<Integer> row,int target) {
        if (row.size() == 1 && row.get(0) != target) {
            return false;
        } else if (row.size() == 1) {
            return true;
        } else {
            int temp = row.get(row.size()/2);
            if(temp == target) {
                return true;
            } else if (temp > target) {
                return mergeSearch(row.subList(0, row.size()/2), target);
            } else  {
                return mergeSearch(row.subList(row.size()/2, row.size()), target);
            }
        }
    } 
}
