package Same_Tree;

public class MySolnST {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println(isSameTree(p, q));
    }

    // 100% speed !!!, 42% mem
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) { // null
            return true;
        } else if (((p == null && q != null) || (p != null && q == null)) || p.val != q.val ) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
