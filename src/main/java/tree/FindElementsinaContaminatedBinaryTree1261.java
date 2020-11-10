package tree;

import java.util.Stack;

public class FindElementsinaContaminatedBinaryTree1261 {
    /*
    private final HashSet<Integer> set = new HashSet<>();

    public FindElementsinaContaminatedBinaryTree1261(TreeNode root) {
        final Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final Pair<TreeNode, Integer> pair = queue.poll();
                final TreeNode node = pair.getKey();
                final int value = pair.getValue();
                node.val = value;
                set.add(value);
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, value * 2 + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, value * 2 + 2));
                }
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
     */
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    private final TreeNode root;

    public FindElementsinaContaminatedBinaryTree1261(TreeNode root) {
        this.root = root;
    }

    public boolean find(int target) {
        final Stack<Integer> stack = new Stack<>();
        while (target > 0) {
            if (target % 2 == 0) {
                stack.push(RIGHT);
                target = (target - 2) >> 1;
            } else {
                stack.push(LEFT);
                target = (target - 1) >> 1;
            }
        }
        TreeNode current = root;
        while (current != null) {
            if (stack.isEmpty()) {
                return true;
            }
            if (stack.pop() == LEFT) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }
}