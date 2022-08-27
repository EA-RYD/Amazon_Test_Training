package Rearrange_Array_Elements_by_Sign;
import java.util.*;

public class MySolnRAES {
    public static void main(String[] args) {
        
    }

    public static int[] rearrangeArray(int[] nums) {
        int [] out = new int [nums.length];
        // two pointers one for even and one for odd
        int j = 0; 
        int k = 1; 
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= 0){
                out[j] = nums[i];
                j += 2;
            }else {
                out[k] = nums[i];
                k += 2;
            }
        }
        return out;
    }
}
