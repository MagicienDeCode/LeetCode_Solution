package tree;

import java.util.Stack;

public class MinimumAbsoluteDifferenceinBST530 {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        TreeNode previous = null;
        // iterative inorder traversal
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                // preorder here
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            // inorder here
            if (previous != null) {
                min = Math.min(min, current.val - previous.val);
            }
            previous = current;
            current = current.right;
        }
        return min;
    }
    /*
    int min = Integer.MAX_VALUE;
    TreeNode previous = null;

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        // preorder here
        inorder(root.left);
        // inorder here
        if (previous != null) {
            min = Math.min(min, root.val - previous.val);
        }
        previous = root;
        inorder(root.right);
    }
     */
}
