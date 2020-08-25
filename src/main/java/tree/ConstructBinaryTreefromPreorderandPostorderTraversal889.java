package tree;

public class ConstructBinaryTreefromPreorderandPostorderTraversal889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        // preorder root left right
        // postorder  left right root
        return construct(pre,
                0,
                pre.length - 1,
                post,
                0,
                post.length - 1
        );
    }

    private TreeNode construct(int[] preorder,
                               int preStart,
                               int preEnd,
                               int[] postorder,
                               int postStart,
                               int postEnd
    ) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        final TreeNode treeNode = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return treeNode;
        }
        /*
        preorder = 1 245 367
        postorder = 452 673 1
        root = 1
        leftStartValue = 2
        then just find the 2 in postorder
         */
        int indexInPost = postStart;
        final int leftStartValue = preorder[preStart + 1];
        while (indexInPost < preorder.length && postorder[indexInPost] != leftStartValue) {
            ++indexInPost;
        }
        treeNode.left =
                construct(preorder,
                        preStart + 1,
                        preStart + 1 + indexInPost - postStart,
                        postorder,
                        postStart,
                        indexInPost);
        treeNode.right =
                construct(preorder,
                        preStart + 2 + indexInPost - postStart,
                        preEnd,
                        postorder,
                        indexInPost + 1,
                        postEnd - 1);
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
