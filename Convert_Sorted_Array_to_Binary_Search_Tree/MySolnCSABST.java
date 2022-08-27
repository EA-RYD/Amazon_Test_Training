package Convert_Sorted_Array_to_Binary_Search_Tree;
import java.util.*;

public class MySolnCSABST {
    /*
     * Given an integer array nums where the elements are sorted in ascending order, 
     * convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth 
of the two subtrees of every node never differs by more than one.
     */
    public static void main(String[] args) {
        
    }

    /*
     * Key is here to make Node out of middle number and 
     * pass on the left of the array to form left tree and 
     * right half of the tree to form the right array
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }
    
    public TreeNode helper(int[] nums, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}
