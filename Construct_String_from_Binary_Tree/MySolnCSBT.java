package Construct_String_from_Binary_Tree;
import java.util.*;

public class MySolnCSBT {
    /*
     * Given the root of a binary tree, 
     * construct a string consisting of parenthesis and integers 
     * from a binary tree with the preorder traversal way, and return it.

Omit all the empty parenthesis pairs that do not affect the one-to-one
 mapping relationship between the string and the original binary tree.
     */
    public static void main(String[] args) {
        
    }

    public static String tree2str(TreeNode root) {
        if (root == null) return "";
        StringBuilder str = new StringBuilder();
        traverse(root, str);
        return str.toString();
    }

    private static void traverse(TreeNode root, StringBuilder str) {
        str.append(root.val);
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            str.append("(");
            traverse(root.left, str);
            str.append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                str.append("()");
            }
            str.append("(");
            traverse(root.right, str);
            str.append(")");
        }
    }
}
