package tree;

import java.util.Stack;

public class SubtreeofAnotherTree572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = s;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (current.val == t.val) {
                if (isSameTree(current, t)) {
                    return true;
                }
            }
            current = current.right;
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
