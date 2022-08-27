package Flatten_Binary_Tree_to_Linked_List;
import java.util.*;

public class MySolnFBTLL {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        flatten(root);
        for (Integer i : rightSideView(root)) {
            System.out.println(i);
        }
    }

    //This solution is based on recursion. We simply flatten left and right subtree and paste each
    // sublist to the right child of the root. (don't forget to set left child to null)
    public static void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }


    public static List<Integer> rightSideView(TreeNode root) {
        //Queue<TreeNode> que = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        iterateRight(result, root, 0);
        return result;
    }

    //visit the right first, then for each level, 
   //  the first appear number is the rightmost of current level.
    private static void iterateRight(List<Integer> result, TreeNode root,int level) {
        if (root == null) 
            return;
        if (level == result.size()) 
            result.add(root.val);
        iterateRight(result, root.right, level + 1);
        iterateRight(result, root.left, level + 1);
        
    }
}
