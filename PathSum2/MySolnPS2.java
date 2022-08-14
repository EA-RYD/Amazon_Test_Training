package PathSum2;
import java.util.*;

public class MySolnPS2 {
    /*
     * Given the root of a binary tree and an integer targetSum, 
     * return all root-to-leaf paths where the sum of the node values 
     * in the path equals targetSum. Each path should be returned as a 
     * list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any 
leaf node. A leaf is a node with no children.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        /* 
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(-1);
        root.left.left.right = new TreeNode(1);
        root.left.left.right.left = new TreeNode(-7);
        root.left.right = new TreeNode(6);
        //root.right = new TreeNode(0);
        //root.right.left = new TreeNode(13);
        //root.right.right = new TreeNode(4);
        //root.right.right.left = new TreeNode(5);
        //root.right.right.right = new TreeNode(1);
        */
        int targetSum = 0;

        System.out.println();
        for (List<Integer> l : pathSum(root, targetSum)) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    //faster than 84.19%, 60 mem
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        traverse(root, targetSum, 0, res, new ArrayList<>(), 0);
        return res;
    }

    private static void traverse(TreeNode root, int target, int add, List<List<Integer>> res, List<Integer> temp, int level) {
        if (root == null) {       
            return;
        }  else if ((root.left == null && root.right == null)) {
            if (level == 0 && root.val != target)
                return;
            temp.add(root.val);
            add+=root.val;
            if (add == target) 
                res.add(new ArrayList<>(temp)); 
            temp.remove(temp.size()-1);        
            return;
        } else {
            temp.add(root.val);
            traverse(root.left, target, add + root.val, res, temp,level+1);
            traverse(root.right, target, add + root.val, res, temp,level+1);
            temp.remove(temp.size()-1);
        }
    }
}
