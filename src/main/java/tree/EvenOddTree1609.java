package tree;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree1609 {

    private static final int ODD = 1;
    private static final int EVEN = 0;

    public boolean isEvenOddTree(TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            int pre = -1;
            for (int size = 0; size < currentSize; size++) {
                final TreeNode node = queue.poll();
                if (node.val % 2 == flag) {
                    return false;
                }
                if (pre != -1) {
                    if (flag == ODD && pre <= node.val) {
                        return false;
                    }
                    if (flag == EVEN && pre >= node.val) {
                        return false;
                    }
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                pre = node.val;
            }
            flag = flag == EVEN ? ODD : EVEN;
        }
        return true;
    }
}
