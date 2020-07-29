package binary_tree;

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // inorder  left root right
        // preorder root left right
        return construct(inorder,
                0,
                inorder.length - 1,
                preorder,
                0,
                preorder.length - 1
        );
    }

    private TreeNode construct(int[] inorder,
                               int iStart,
                               int iEnd,
                               int[] preorder,
                               int pStart,
                               int pEnd
    ) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        final TreeNode treeNode = new TreeNode(preorder[pStart]);
        int index = iStart;
        while (iStart < inorder.length && inorder[index] != treeNode.val) {
            ++index;
        }
        treeNode.left =
                construct(inorder,
                        iStart,
                        index - 1,
                        preorder,
                        pStart + 1,
                        pStart + index - iStart);
        treeNode.right =
                construct(inorder,
                        index + 1,
                        iEnd,
                        preorder,
                        pStart + index - iStart + 1,
                        pEnd);
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
