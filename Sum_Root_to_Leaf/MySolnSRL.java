package Sum_Root_to_Leaf;
import java.util.*;

public class MySolnSRL {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        ArrayList<String> nums = new ArrayList<>();
        int sum = 0;
        traverse(nums, root, "");
        for (String string : nums) {
            sum+=Integer.parseInt(string);
        }

        return sum;
    }

    public static void traverse(ArrayList<String> nums,TreeNode root, String temp) {
        if (root.left == null && root.right == null) {
            temp += root.val;
            nums.add(temp);
            return;
        } else if (root.left == null) {
            temp += root.val;
            traverse(nums, root.right, temp);
        } else if (root.right == null) {
            temp += root.val;
            traverse(nums, root.left, temp);
        } else {
            temp += root.val;
            traverse(nums, root.left, temp);
            traverse(nums, root.right, temp);
        }
    }
}
