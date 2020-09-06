package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTreeIterator173 {

    private final List<Integer> values = new ArrayList<>();
    private int index = -1;

    public BinarySearchTreeIterator173(TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            values.add(current.val);
            current = current.right;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return values.get(++index);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return index < values.size() - 1;
    }
}
