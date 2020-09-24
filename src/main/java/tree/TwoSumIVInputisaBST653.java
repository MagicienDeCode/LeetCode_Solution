package tree;

import java.util.HashSet;
import java.util.Stack;

public class TwoSumIVInputisaBST653 {
    public boolean findTarget(TreeNode root, int k) {
        final HashSet<Integer> set = new HashSet<>();
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                // preorder here
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            // BST / inorder here
            if (set.contains(k - current.val)) {
                return true;
            }
            set.add(current.val);
            current = current.right;
        }
        return false;
    }
}
