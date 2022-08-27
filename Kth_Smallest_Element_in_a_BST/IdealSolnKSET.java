package Kth_Smallest_Element_in_a_BST;
import java.util.*;

public class IdealSolnKSET {
    /*
     * Solutions:
     * 1. In-order traversal, k-1 position in sorted array is result
     * 2. Using Stack as Iterator
     *      We use idea from 173. Binary Search Tree Iterator to 
     *      iterate elements in order in O(H) in Space Comlpexity.
        The idea is that we iterate through the BST, we pop from smallest 
        elements and we just need to pop k times to get the k_th smallest element.



    Time: O(H + k), where H is the height of the BST.
    Space: O(H)

     */

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        pushLeft(stack, root);
        while (--k > 0) {
            pushLeft(stack, stack.pop().right);
        }
        return stack.pop().val;
    }
    void pushLeft(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
