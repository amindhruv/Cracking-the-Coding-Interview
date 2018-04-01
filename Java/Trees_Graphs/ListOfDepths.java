package Trees_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6, new TreeNode(5), new TreeNode(7)));
        ArrayList<LinkedList<TreeNode>> levels = getListOfDepths(root);
        for (LinkedList<TreeNode> level : levels) {
            while (!level.isEmpty())
                System.out.print(level.poll().value + " ");
            System.out.println();
        }
    }

    private static ArrayList<LinkedList<TreeNode>> getListOfDepths(TreeNode root) {
        if (root == null) return null;
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        current.add(root);
        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null)
                    current.add(parent.left);
                if (parent.right != null)
                    current.add(parent.right);
            }
        }
        return result;
    }
}
