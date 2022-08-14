package Merge_Two_Binary_Trees;

import java.io.PrintStream;
import java.util.*;

import apple.laf.JRSUIUtils.Tree;

public class MySolnMTBT {
    /*
     * You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of 
the two trees are overlapped while the others are not. You need to merge the two 
trees into a new binary tree. The merge rule is that if two nodes overlap, 
then sum node values up as the new value of the merged node. Otherwise, 
the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.
     */
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        /* 
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        */
        TreeNode root2 = new TreeNode(1);
        
        root2.left = new TreeNode(2);
        /* 
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        */

        TreeNode newRoot = mergeTrees(root1, root2);
        printLevelOrder(newRoot);
        
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode newNode = new TreeNode();
        traverse(root1, root2, newNode);
        return newNode;
    }

    public static void traverse(TreeNode root1, TreeNode root2,TreeNode newNode) {
        if (root1 == null && root2 == null) {
            return;
        } else if (root1 == null) {
            newNode.val = root2.val;
            if (root2.left != null)
                newNode.left = new TreeNode();
            if (root2.right != null)
                newNode.right = new TreeNode();

            traverse(root1, root2.left, newNode.left);
            traverse(root1, root2.right, newNode.right);
        } else if (root2 == null) {
            newNode.val = root1.val;
            if (root1.left != null)
                newNode.left = new TreeNode();
            if (root1.right != null)
                newNode.right = new TreeNode();

            traverse(root1.left, root2, newNode.left);
            traverse(root1.right, root2, newNode.right);
        } else {
            newNode.val = root1.val + root2.val;
            
            if (root1.left != null || root2.left != null)
                newNode.left = new TreeNode();
            if (root1.right != null || root2.right != null)
                newNode.right = new TreeNode();

            traverse(root1.left, root2.left, newNode.left);
            traverse(root1.right, root2.right, newNode.right);
        }

    }

    public static void traversePreOrder(StringBuilder sb, String padding, String pointer, TreeNode node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.val);
            sb.append("\n");
    
            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");
    
            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (node.right != null) ? "├──" : "└──";
    
            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.left);
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.right);
        }
    }

    public static void printLevelOrder(TreeNode r) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(r);
        queue.add(null);
        while (!queue.isEmpty()) {
    
            TreeNode temp = queue.poll();
            if(temp!=null)
                System.out.print(temp.val + " ");
    
            if(temp == null) {
                System.out.println();
                if(queue.isEmpty()) break;
                queue.add(null);
                continue;
            }
    
            /*Enqueue left child */
            if (temp.left != null) {
                queue.add(temp.left);
            }
    
            /*Enqueue right child */
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
}
