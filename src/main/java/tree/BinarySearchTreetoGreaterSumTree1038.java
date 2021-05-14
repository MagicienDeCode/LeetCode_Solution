package tree;

public class BinarySearchTreetoGreaterSumTree1038 {
    public TreeNode bstToGst(TreeNode root) {
        dfsRightMidLeft(root, new int[]{0});
        return root;
    }

    private void dfsRightMidLeft(TreeNode root, int[] ints) {
        if (root.right != null) {
            dfsRightMidLeft(root.right, ints);
        }
        ints[0] += root.val;
        root.val = ints[0];
        if (root.left != null) {
            dfsRightMidLeft(root.left, ints);
        }
    }
    /*
    public TreeNode bstToGst(TreeNode root) {
        int sum = 0;
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }
            current = stack.pop();
            sum += current.val;
            current.val = sum;
            current = current.left;
        }
        return root;
    }
     */
}
