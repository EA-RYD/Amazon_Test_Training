package Leaf_Similar_Trees;
import java.util.*;

public class MySolnLST {
    /*
     * Consider all the leaves of a binary tree, 
     * from left to right order, the values of those leaves form a leaf value sequence.
     */
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.left.left = new TreeNode(6);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.left.right = new TreeNode(7);
        root2.left.left = new TreeNode(6);
        root2.right = new TreeNode(1);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        System.out.println(leafSimilar(root1, root2));
    }

    //100.00% 
    //leaf is when left and right are both null
    //could also do stringbuilder
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> rootLeafs1 = new ArrayList<>();
        ArrayList<Integer> rootLeafs2 = new ArrayList<>();
        search(root1, rootLeafs1);
        search(root2, rootLeafs2);
        return rootLeafs1.equals(rootLeafs2);
    }

    public static void search(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            arr.add(root.val); 
            return;
        } else {
            search(root.left, arr);
            search(root.right, arr);
        }
    }
}
