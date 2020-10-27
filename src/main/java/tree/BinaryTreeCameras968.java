package tree;

public class BinaryTreeCameras968 {

    private static final int MUST_HAVE_CAMERA = 1;
    private static final int MUST_NOT_HAVE_CAMERA = -1;
    private static final int CAMERA = 7;

    private int result = 0;


    public int minCameraCover(TreeNode root) {
        final int dfs = dfs(root);
        if (dfs == MUST_HAVE_CAMERA) {
            result++;
        }
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return MUST_NOT_HAVE_CAMERA;
        }
        final int leftResult = dfs(root.left);
        final int rightResult = dfs(root.right);

        if (leftResult == MUST_HAVE_CAMERA || rightResult == MUST_HAVE_CAMERA) {
            result++;
            return CAMERA;
        }

        if (leftResult == CAMERA || rightResult == CAMERA) {
            return MUST_NOT_HAVE_CAMERA;
        }

        return MUST_HAVE_CAMERA;
    }
}
