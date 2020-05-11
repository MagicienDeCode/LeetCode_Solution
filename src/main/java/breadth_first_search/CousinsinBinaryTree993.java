package breadth_first_search;

import java.util.*;

public class CousinsinBinaryTree993 {
    public boolean isCousins(final TreeNode root, final int x, final int y) {
        if (root == null) {
            return false;
        }
        final Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (treeNodeQueue.size() != 0) {
            final List<Integer> currentLevel = new ArrayList<>();
            int currentSize = treeNodeQueue.size();
            for (int i = 0; i < currentSize; i++) {
                final TreeNode currentNode = treeNodeQueue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.val == 0) {
                    continue;
                }
                treeNodeQueue.offer(
                        Objects.requireNonNullElseGet(currentNode.left, () -> new TreeNode(0)));
                treeNodeQueue.offer(
                        Objects.requireNonNullElseGet(currentNode.right, () -> new TreeNode(0)));
            }
            final int indexX = currentLevel.indexOf(x);
            if (indexX != -1) {
                final int indexY = currentLevel.indexOf(y);
                if (indexY == -1) {
                    return false;
                } else if (indexX % 2 == 0) {
                    return indexX + 1 != indexY;
                } else {
                    return indexX - 1 != indexY;
                }
            }
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
