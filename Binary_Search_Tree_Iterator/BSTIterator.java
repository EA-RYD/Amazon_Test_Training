package Binary_Search_Tree_Iterator;
import java.util.*;
/*
 * This means I cannot use a lot of memory, which suggests that I need to make 
 * use of the tree structure itself. And also, one thing to notice is the 
 * "average O(1) run time". It's weird to say average O(1), because there's 
 * nothing below O(1) in run time, which suggests in most cases, I solve it in 
 * O(1), while in some cases, I need to solve it in O(n) or O(h). These two 
 * limitations are big hints.

Before I come up with this solution, I really draw a lot binary trees and try 
inorder traversal on them. We all know that, once you get to a TreeNode, in order 
to get the smallest, you need to go all the way down its left branch. So our first 
step is to point to pointer to the left most TreeNode. The problem is how to do 
back trace. Since the TreeNode doesn't have father pointer, we cannot get a 
TreeNode's father node in O(1) without store it beforehand. Back to the first 
step, when we are traversal to the left most TreeNode, we store each TreeNode 
we met ( They are all father nodes for back trace).

After that, I try an example, for next(), I directly return where the pointer 
pointing at, which should be the left most TreeNode I previously found. What 
to do next? After returning the smallest TreeNode, I need to point the pointer 
to the next smallest TreeNode. When the current TreeNode has a right branch
 (It cannot have left branch, remember we traversal to the left most), 
 we need to jump to its right child first and then traversal to its right 
 child's left most TreeNode. When the current TreeNode doesn't have a right
  branch, it means there cannot be a node with value smaller than itself father 
  node, point the pointer at its father node.
 */
public class BSTIterator {
    // in order traversal
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode head = root;
        while (head != null) {
            stack.push(head);
            if (head.left != null)
                head = head.left;
            else    
                break;
        }
        
    }
    
    public int next() {
        TreeNode node = stack.pop();
        TreeNode ref = node;

        //traverse right branch
        if (ref.right != null) {
            ref = ref.right;
            while (ref != null) {
                stack.push(ref);
                if (ref.left != null)
                    ref = ref.left;
                else 
                    break;
            }
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
