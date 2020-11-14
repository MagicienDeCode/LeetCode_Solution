package tree;

public class CountGoodNodesinBinaryTree1448 {

    int sum = 0;

    public int goodNodes(TreeNode root) {
        sum = 0;
        dfs(root, root.val);
        return sum;
    }

    private void dfs(TreeNode root, int maxValue) {
        if (root == null) {
            return;
        }
        if (root.val >= maxValue) {
            ++sum;
            maxValue = root.val;
        }
        dfs(root.left, maxValue);
        dfs(root.right, maxValue);
    }
}
