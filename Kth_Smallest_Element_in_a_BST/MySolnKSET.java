package Kth_Smallest_Element_in_a_BST;
import java.util.*;

public class MySolnKSET {
    /*
     * Given the root of a binary search tree, 
     * and an integer k, return the kth smallest 
     * value (1-indexed) of all the values of the nodes in the tree.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;

        System.out.println(kthSmallest(root, k));
    }

    public static int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(k,(x,y) -> Integer.compare(y, x));
        traverse(que, root, k);
        return que.poll();
    }

    public static void traverse(PriorityQueue<Integer> que, TreeNode root, int k) {
        if (root == null) {
            return;
        } else {
            que.offer(root.val);
            if (que.size() > k) 
                que.poll();
            traverse(que, root.left, k);
            traverse(que, root.right, k);
        }
    }

}
