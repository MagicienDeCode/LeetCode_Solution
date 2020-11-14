package tree;

public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree1379 {

    TreeNode result = null;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(original, cloned, target);
        return result;
    }

    private void dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) {
            return;
        }
        if (original == target) {
            result = cloned;
        }
        dfs(original.left, cloned.left, target);
        dfs(original.right, cloned.right, target);
    }
}
