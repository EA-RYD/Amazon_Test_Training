package Convert_BST_to_Greater_Tree;
import java.util.*;

public class MySolnCBTGT {
    /*
     * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such 
     * that every key of the original BST is changed to the original key plus the sum 
     * of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(8);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root = convertBST(root);
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = que.poll();
                System.out.print(temp.val + " ");

                if (temp.left != null) 
                    que.offer(temp.left);

                if (temp.right != null)
                    que.offer(temp.right);
            }
            System.out.println();
        }
    }

    public static TreeNode convertBST(TreeNode root) {
        TreeNode ref = root;
        if (root == null || (root.left == null && root.right == null)) return root;
        Stack<TreeNode> stack = new Stack<>();

        
        int currentTotal = 0;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.right;
            }
            root = stack.pop();
            currentTotal+=root.val;
            root.val = currentTotal;
            root = root.left;
        }
        
        return ref;
    }
}
