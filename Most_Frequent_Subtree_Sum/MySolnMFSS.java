package Most_Frequent_Subtree_Sum;
import java.util.*;
import java.util.stream.Stream;

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
        root.right = new TreeNode(-5);
        for (int i : findFrequentTreeSum(root)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        int[] max = new int[1];
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        traverse(map, root, max);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == max[0]) {
                res.add(entry.getKey());
            }
        }
        return res.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
    }

    private static int traverse(HashMap<Integer,Integer> map, TreeNode root, int[] max) {
        if (root == null) return 0;
        else  {
            int left = traverse(map, root.left, max);
            int right = traverse(map, root.right, max);
            int totalTree = left + right + root.val;
            map.put(totalTree, map.getOrDefault(totalTree, 0) + 1);
            max[0] = Integer.max(max[0], map.get(totalTree));
            return totalTree; // in case leaf node
        }
    }
}
