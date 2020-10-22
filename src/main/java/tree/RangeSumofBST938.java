package tree;

import java.util.Stack;

public class RangeSumofBST938 {
    public int rangeSumBST(TreeNode root, int l, int r) {
        int result = 0;
        if (root == null) {
            return 0;
        }
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                // preorder
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            // inorder
            if (current.val > r) {
                break;
            }
            if (current.val >= l) {
                result += current.val;
            }
            current = current.right;
        }
        return result;
    }
}
