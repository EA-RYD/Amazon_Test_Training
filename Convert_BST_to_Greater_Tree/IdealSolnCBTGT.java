package Convert_BST_to_Greater_Tree;
import java.util.*;

public class IdealSolnCBTGT {
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
    
    static int sum = 0;
    public static TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    
    public static void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}
