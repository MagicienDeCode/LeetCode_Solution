package tree;

public class ConstructBinarySearchTreefromPreorderTraversal1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, 0, preorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int start, int end) {
        if (start > end || start == preorder.length) {
            return null;
        }
        final TreeNode current = new TreeNode(preorder[start]);
        int rightIndex = start + 1;
        while (rightIndex <= end && current.val > preorder[rightIndex]) {
            ++rightIndex;
        }
        current.left = construct(preorder, start + 1, rightIndex - 1);
        current.right = construct(preorder, rightIndex, end);
        return current;
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
