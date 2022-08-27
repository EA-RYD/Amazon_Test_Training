package Serialize_and_Deserialize_Binary_Tree;

public class MainTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        Codec c = new Codec();
        System.out.println(c.serialize(root));
    }
}
