package Search_a_2D_Matrix_II;

public class MySolnS2DM2 {

    /*
     * 
     * Write an efficient algorithm that searches for a value target in 
     * an m x n integer matrix matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

     */
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22}};
        int target = 20;
        System.out.println(searchMatrix(matrix, target));
    }
    //start from top right because it is the middle of all vals
    /*
     * 
     * We start search the matrix from top right corner,
     *  initialize the current position to top right corner, 
     * if the target is greater than the value in current position,
     *  then the target can not be in entire row of current position 
     * because the row is sorted, if the target is less than the value 
     * in current position, then the target can not in the entire column 
     * because the column is sorted too. We can rule out one row or one
     *  column each time, so the time complexity is O(m+n).
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        //top right to bottom left
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
