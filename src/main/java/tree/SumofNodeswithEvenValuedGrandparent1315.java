package tree;

public class SumofNodeswithEvenValuedGrandparent1315 {
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        dfs(root, -1, -1);
        return sum;
    }

    private void dfs(TreeNode root, int parent, int grandParent) {
        if (root == null) {
            return;
        }
        if (grandParent > 0 && grandParent % 2 == 0) {
            sum += root.val;
        }
        dfs(root.left, root.val, parent);
        dfs(root.right, root.val, parent);
    }
}
