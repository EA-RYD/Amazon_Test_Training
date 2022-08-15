package Binary_Tree_Level_Order_Traversal;
import java.util.*;

//import apple.laf.JRSUIUtils.Tree;

public class MySolnBTLOT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        for (List<Integer> l : levelOrder(root)) {
            System.out.println(l);
        }
    }

    //faster than  93.16%
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        que.offer(root);
        
        while (!que.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cnt = que.size();
            for(int i = 0;i < cnt;i++){
                TreeNode tempNode = que.poll();
                temp.add(tempNode.val);
                if(tempNode.left != null)
                    que.offer(tempNode.left);
                
                if(tempNode.right != null)
                    que.offer(tempNode.right);
            }
            res.add(temp);
        }

        return res;
    }
}
