package Max_Width_Binary_Tree;

import java.util.*;

//import org.omg.CORBA.ACTIVITY_COMPLETED;

public class MySolnMXBT {
    /*
     * 
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        //root.left.right = new TreeNode(3);  
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(7);
        //root.right.left.left = new TreeNode(7);

        System.out.println(widthOfBinaryTree(root));

    }

    
    public static int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        HashMap<TreeNode,Integer> nodePos = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) return max;
        que.offer(root);
        nodePos.put(root,1);
        
        // just do right to left and track nulls
        while (!que.isEmpty()) {
            int cnt = que.size(), start = 0, end = 0;

            for(int i = 0;i < cnt;i++){
                TreeNode tempNode = que.poll();
                if (i == 0) start = nodePos.get(tempNode);
                if (i == cnt-1) end = nodePos.get(tempNode);

                if(tempNode.left != null) {
                    que.offer(tempNode.left);
                    nodePos.put(tempNode.left, nodePos.get(tempNode) * 2);
                }
                   
                if(tempNode.right != null) {
                    que.offer(tempNode.right);
                    nodePos.put(tempNode.right, nodePos.get(tempNode) * 2 + 1);
                }
            }
            max = (end - start + 1) > max ? (end - start + 1) : max; //+1 because starts from 0 which doesnt rep actual nodes that start with 1
        }

        return max;
    }
    
    
}
