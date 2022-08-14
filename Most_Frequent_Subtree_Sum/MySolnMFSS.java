package Most_Frequent_Subtree_Sum;

public class MySolnMFSS {

    /*
     * Given the root of a binary tree, return the most frequent subtree sum. 
     * If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values formed by the 
subtree rooted at that node (including the node itself).
     * 
     * 
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        System.out.println();
        for (int i : findFrequentTreeSum(root)) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        

        return null;
    }
}
