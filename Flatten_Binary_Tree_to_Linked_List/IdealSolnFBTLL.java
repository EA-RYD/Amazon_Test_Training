package Flatten_Binary_Tree_to_Linked_List;

public class IdealSolnFBTLL {

    private TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
