package binarysearch;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class CountCompleteTreeNodes222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode current = root;
        while (current.left != null) {
            level++;
            current = current.left;
        }
        return search(root, level);
    }

    private int search(final TreeNode root, final int level) {
        int left = 1 << level;
        int right = (1 << level + 1) - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (isNotNull(root, level, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (isNotNull(root, level, right)) {
            return right;
        }
        if (isNotNull(root, level, left)) {
            return left;
        }
        return -1;
    }

    private boolean isNotNull(final TreeNode root, int level, final int target) {
        TreeNode currentNode = root;
        int start = 1 << level;
        int end = (1 << level + 1) - 1;
        while (level > 0) {
            final int mid = start + ((end - start) >> 1);
            if (target > mid) {
                currentNode = currentNode.right;
                start = mid;
            } else {
                currentNode = currentNode.left;
                end = mid;
            }
            level--;
        }
        return currentNode != null;
    }
}
