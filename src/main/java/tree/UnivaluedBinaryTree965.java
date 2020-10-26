package tree;

import java.util.Stack;

public class UnivaluedBinaryTree965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        final int value = root.val;
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                // preorder here
                if (current.val != value) {
                    return false;
                }
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return true;
    }
}
