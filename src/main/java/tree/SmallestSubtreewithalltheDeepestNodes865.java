package tree;

public class SmallestSubtreewithalltheDeepestNodes865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }
        final Result leftResult = dfs(root.left);
        final Result rightResult = dfs(root.right);
        if (leftResult.depth == rightResult.depth) {
            return new Result(root, leftResult.depth + 1);
        } else if (leftResult.depth > rightResult.depth) {
            return new Result(leftResult.node, leftResult.depth + 1);
        } else {
            return new Result(rightResult.node, rightResult.depth + 1);
        }
    }

    static class Result {
        TreeNode node;
        int depth;

        public Result(TreeNode node, int d) {
            this.node = node;
            this.depth = d;
        }
    }
}
