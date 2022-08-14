package Subtree_of_Another_Tree;
import java.util.*;

public class MySolnSAT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(1);
        /* 
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.left = new TreeNode(0);
        */
        TreeNode subRoot = new TreeNode(1);
        /* 
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);
        */
        System.out.println(isSubtree(root, subRoot));

    }

    // once we find root in root that has value of sub root then we start equal process
    // 97.61, 13 mem
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        } else if (root.val == subRoot.val) {
            boolean eq = equalCheck(root, subRoot);
            if (eq)
                return equalCheck(root, subRoot);
            else    
                return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private static boolean equalCheck(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if ((root == null || subRoot == null)||(root.val != subRoot.val)) {
            return false;
        } else {
            return equalCheck(root.left, subRoot.left) && equalCheck(root.right, subRoot.right);
        }
    }
}
