package tree;

public class BalancedBinaryTree110 {

    private static final int NOT_BALANCED = -99;

    public boolean isBalanced(TreeNode root) {
        return helper(root) != NOT_BALANCED;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int leftResult = helper(root.left);
        final int rightResult = helper(root.right);

        // 3 situations return NOT_BALANCED
        if (leftResult == NOT_BALANCED ||
                rightResult == NOT_BALANCED ||
                Math.abs(leftResult - rightResult) > 1) {
            return NOT_BALANCED;
        }
        return Math.max(leftResult, rightResult) + 1;
    }

    /*
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    public Result helper(TreeNode root) {
        if (root == null) {
            return new Result(true, 0);
        }

        final Result leftResult = helper(root.left);
        final Result rightResult = helper(root.right);

        // 3 situations return false
        if (!leftResult.isBalanced ||
                !rightResult.isBalanced ||
                Math.abs(leftResult.height - rightResult.height) > 1) {
            return new Result(false, -99);
        }
        // return true
        // return new Result(true, 0);
        return new Result(true, Math.max(leftResult.height, rightResult.height) + 1);
    }

    static class Result {
        boolean isBalanced;
        int height;

        public Result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
     */
}
