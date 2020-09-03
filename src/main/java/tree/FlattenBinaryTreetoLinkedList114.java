package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreetoLinkedList114 {
    public void flatten(TreeNode root) {
        final List<Integer> values = new ArrayList<>();
        final List<TreeNode> nodes = new ArrayList<>();
        TreeNode current = root;
        final Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                values.add(current.val);
                nodes.add(current);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        for (int i = 0; i < values.size(); i++) {
            final TreeNode node = nodes.get(i);
            node.val = values.get(i);
            if (i != values.size() - 1) {
                node.left = null;
                node.right = nodes.get(i + 1);
            } else {
                node.right = null;
                node.left = null;
            }
        }
    }
}
