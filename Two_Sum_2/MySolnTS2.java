package Two_Sum_2;
import java.util.*;
/*Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
find two numbers such that they add up to a specific target number. Let these two numbers be
 numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array 
[index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 */
public class MySolnTS2 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        for (int i : twoSum(numbers, target))
            System.out.print(i + " ");
        System.out.println();
    }

    //80%
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0,j = numbers.length-1;i<j;) {
            if (numbers[j] + numbers[i] > target)
                j--;
            else if (numbers[i] + numbers[j] == target) {
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            } else {
                i++;
            }
                
                
        }
        
        return ans;
    }
}
