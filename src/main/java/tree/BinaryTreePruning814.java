package tree;

public class BinaryTreePruning814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        final int result = prune(root);
        if (result == 0) {
            return null;
        } else {
            return root;
        }
    }

    private int prune(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int leftResult = prune(root.left);
        final int rightResult = prune(root.right);
        if (leftResult == 0) {
            root.left = null;
        }
        if (rightResult == 0) {
            root.right = null;
        }
        return root.val + leftResult + rightResult;
    }
}
