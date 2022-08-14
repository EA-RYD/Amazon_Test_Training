package Binary_Tree_Right_Side_View;

import java.util.*;

public class MySolnBTRS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        for (Integer i : rightSideView(root)) {
            System.out.println(i);
        }
    }


    /*
     * For breadth first, add all children to the queue, 
     * then pull the head and do a breadth first search on it, using the same queue.

For depth first, add all children to the stack, 
then pop and do a depth first on that node, using the same stack.
     */
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
