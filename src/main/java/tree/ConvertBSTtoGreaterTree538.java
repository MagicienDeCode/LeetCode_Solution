package tree;

import java.util.Stack;

public class ConvertBSTtoGreaterTree538 {

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }
            current = stack.pop();
            sum += current.val;
            current.val = sum;
            current = current.left;
        }
        return root;
    }
    /*
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        inorder(root);
        return root;
    }

    // reversed inorder !!
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        // preorder here
        inorder(root.right);
        // inorder here
        sum += root.val;
        root.val = sum;
        inorder(root.left);
    }
     */
}
