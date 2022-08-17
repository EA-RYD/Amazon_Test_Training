package Search_a_2D_Matrix;

public class IdealSolnS2DM {
    /**
 *  Do binary search in this "ordered" matrix
 * log(m*n) eff
 * log m to find row, log n to find number or not
 * treating matrix like one long array
 */
public boolean searchMatrix(int[][] matrix, int target) {
	
	int row_num = matrix.length;
	int col_num = matrix[0].length;
	
	int begin = 0, end = row_num * col_num - 1;
	
	while(begin <= end){
		int mid = (begin + end) / 2;
		int mid_value = matrix[mid/col_num][mid%col_num];
		
		if( mid_value == target){
			return true;
		
		}else if(mid_value < target){
			//Should move a bit further, otherwise dead loop.
			begin = mid+1;
		}else{
			end = mid-1;
		}
	}
	
	return false;
}
}
