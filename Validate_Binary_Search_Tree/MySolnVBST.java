package Validate_Binary_Search_Tree;
import java.util.*;
public class MySolnVBST {
    /*
     * Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(32);
        root.left = new TreeNode(26);
        root.left.left = new TreeNode(19);
        //root.left.right = new TreeNode();
        root.right = new TreeNode(47);
        //root.right.left = new TreeNode();
        root.right.right = new TreeNode(56);
        root.right.right.right = new TreeNode(27);

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return iterate(root.left, root.val, 0,root.val,0) && iterate(root.right, root.val, 1,root.val,1) ;
    }

    //0 is left, 1 is right
    private static boolean iterate(TreeNode root,int prev,int direction,int original, int side) {
        if (root == null) {
            return true;
        } else if ((side == 0 && root.val > original) || (side == 1) && root.val < original) {
            return false;
        } else if (direction == 0) {
            return (root.val < prev) && iterate(root.left, root.val, 0, original,side) && iterate(root.right, root.val, 1,original,side) ;
        } else if (direction == 1) {
            return (root.val > prev) && iterate(root.left, root.val, 0,original,side) && iterate(root.right, root.val, 1,original,side) ;
        }
        return true;
    }

    /* alt
     * 
     * public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
     */
}
