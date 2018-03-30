package Trees_Graphs;

import java.util.Scanner;

public class MinimalBST {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = in.nextInt();
        System.out.print("Enter the numbers: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        in.close();
        TreeNode root = minimalBST(nums, 0, n - 1);
        inOrder(root);
    }

    private static TreeNode minimalBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = minimalBST(nums, start, mid - 1);
        root.right = minimalBST(nums, mid + 1, end);
        return root;
    }

    private static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }
}
