package Most_Frequent_Subtree_Sum;
import java.util.*;

public class IdealSolnMFSS {
    /*
     * Use a hashMap count to count the subtree sum occurrence.

A sub function dfs(TreeNode node) will
travel through a tree, recursively calculate the sum of subtree,
increment the count, and finally return the sum of the sub tree.
     */
    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res = new ArrayList<>();
        for (int s : count.keySet()) {
            if (count.get(s) == maxCount)
                res.add(s);
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int s = dfs(root.left) + dfs(root.right) + root.val;
        count.put(s, count.getOrDefault(s, 0) + 1);
        maxCount = Math.max(maxCount, count.get(s));
        return s;
    }
}
