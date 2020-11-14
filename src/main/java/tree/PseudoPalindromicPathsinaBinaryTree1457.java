package tree;

public class PseudoPalindromicPathsinaBinaryTree1457 {

    int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        result = 0;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int mask) {
        if (root == null) {
            return;
        }
        mask = mask ^ (1 << (root.val - 1));
        if (root.left == null && root.right == null) {
            if ((mask & (mask - 1)) == 0) {
                ++result;
            }
            return;
        }
        dfs(root.left, mask);
        dfs(root.right, mask);
    }
}
