package binary_tree;

public class ConstructBinaryTreefromPreorderandPostorderTraversal889 {
    int rootIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        rootIndex = 0;
        return construct(pre, post, 0, pre.length - 1);
    }

    private TreeNode construct(int[] pre, int[] post, int start, int end) {
        if (start > end) {
            return null;
        }
        final TreeNode treeNode = new TreeNode(pre[rootIndex++]);
        if (start == end) {
            return treeNode;
        }
        int index = start;
        while (index < post.length && post[index] != pre[rootIndex]) {
            ++index;
        }
        treeNode.left = construct(pre, post, start, index);
        treeNode.right = construct(pre, post, index + 1, end - 1);
        return treeNode;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
