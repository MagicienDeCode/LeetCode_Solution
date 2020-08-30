package tree;

public class RecoverBinarySearchTree99 {
    public void recoverTree(TreeNode root) {
        TreeNode previous = null;
        TreeNode first = null;
        TreeNode second = null;
        // binary tree inorder traversal iteratively
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                parent = current.left;
                while (parent.right != null && parent.right != current) {
                    parent = parent.right;
                }
                if (parent.right == null) {
                    parent.right = current;
                    current = current.left;
                    continue;
                } else {
                    parent.right = null;
                }
            }
            if (previous != null) {
                if (previous.val > current.val) {
                    if (first == null) {
                        first = previous;
                    }
                    second = current;
                }
            }
            previous = current;
            current = current.right;
        }
        // swap value
        final int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    /*
    public void recoverTree(TreeNode root) {
        TreeNode previous = null;
        TreeNode first = null;
        TreeNode second = null;
        // template binary tree inorder traversal iteratively
        final Stack<TreeNode> stacks = new Stack<>();
        TreeNode current = root;
        while (current != null || !stacks.empty()) {
            while (current != null) {
                stacks.push(current);
                current = current.left;
            }
            current = stacks.pop();
            if (previous != null) {
                if (previous.val > current.val) {
                    if (first == null) {
                        first = previous;
                    }
                    second = current;
                }
            }
            previous = current;
            current = current.right;
        }
        // swap value
        final int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    */
    /*
    public void recoverTree(TreeNode root) {
        final List<Integer> values = new ArrayList<>();
        final List<TreeNode> treeNodes = new ArrayList<>();
        inorderTraversal(root, values, treeNodes);
        Collections.sort(values);
        for (int i = 0; i < values.size(); i++) {
            treeNodes.get(i).val = values.get(i);
        }
    }

    private void inorderTraversal(
            TreeNode root,
            List<Integer> values,
            List<TreeNode> treeNodes
    ) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, values, treeNodes);
        values.add(root.val);
        treeNodes.add(root);
        inorderTraversal(root.right, values, treeNodes);
    }
     */
}
