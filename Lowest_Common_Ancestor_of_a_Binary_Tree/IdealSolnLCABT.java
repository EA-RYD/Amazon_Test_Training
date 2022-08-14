package Lowest_Common_Ancestor_of_a_Binary_Tree;

public class IdealSolnLCABT {
    /*
     * 
    if both p and q exist in Tree rooted at root, then return their LCA
    if neither p and q exist in Tree rooted at root, then return null
    if only one of p or q (NOT both of them), exists in Tree rooted at root, return it

     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
}
