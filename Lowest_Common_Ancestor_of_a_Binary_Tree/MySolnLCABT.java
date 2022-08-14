package  Lowest_Common_Ancestor_of_a_Binary_Tree;
import java.util.*;

public class MySolnLCABT {
    /*
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common 
ancestor is defined between two nodes p and q as the lowest node in T that has both 
p and q as descendants (where we allow a node to be a descendant of itself).”
     */
    public static void main(String[] args) {
        
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        parent.put(root, null);
        que.add(root);

        // both in parent
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = que.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                que.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                que.add(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        // p to base ancestor, q to base anscetor until hit p=q, return q, least common anscestor
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }

}
