package Find_Pivot_Index;

public class IdealSolnPI {
    /*
     * We have two arrays. Left one we sum from left to right. Right one we sum from right to left.
The idea is if pivot exsist, leftside + pivot = rightside + pivot.
For example, arr = [1, 3, 7, 6, 5, 6]
left = [1, 4, 11 ,17, 22, 28]
right = [28, 27, 24, 17, 11, 6]
If there is a pivot, it shuould have the same index, then we return it, otherwise return -1;
     */

    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;
        int l = nums.length;
        int[] left = new int[l];
        int[] right = new int[l];
        left[0] = nums[0];
        right[l-1] = nums[l-1];
        
        for(int i = 1; i<l; i++){
            left[i] = nums[i] + left[i-1];
            right[l-1-i] = nums[l-1-i] + right[l-i];
        }
        
        for(int i=0; i< l; i++){
            if(left[i] == right[i]) return i;
        }
        return -1;
    }
}
