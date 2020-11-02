package tree;

public class MaximumBinaryTreeII998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || val > root.val) {
            final TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
