package binary_tree;

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder  left root right
        // postorder left right root
        return construct(inorder,
                0,
                inorder.length - 1,
                postorder,
                0,
                postorder.length - 1
        );
    }

    private TreeNode construct(int[] inorder,
                               int iStart,
                               int iEnd,
                               int[] postorder,
                               int pStart,
                               int pEnd
    ) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        final TreeNode treeNode = new TreeNode(postorder[pEnd]);
        int index = iStart;
        while (iStart < inorder.length && inorder[index] != treeNode.val) {
            ++index;
        }
        treeNode.left =
                construct(inorder,
                        iStart,
                        index - 1,
                        postorder,
                        pStart,
                        pStart + index - 1 - iStart);
        treeNode.right =
                construct(inorder,
                        index + 1,
                        iEnd,
                        postorder,
                        pStart + index - iStart,
                        pEnd - 1);
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
