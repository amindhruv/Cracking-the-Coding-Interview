package Trees_Graphs;

public class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this(value, null, null);
    }

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
