package tree;

public class DeleteNodeinaBST450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        // null, do nothing
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            // key in left tree
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // key in right tree
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                // left tree is null, so root = right tree
                root = root.right;
            } else if (root.right == null) {
                // right tree is null, so root = left tree
                root = root.left;
            } else {
                // search the minimum value in right tree
                TreeNode delete = root.right;
                while (delete.left != null) {
                    delete = delete.left;
                }
                // assign the value
                root.val = delete.val;
                // remove the node with the same value
                root.right = deleteNode(root.right, delete.val);
            }
        }
        return root;
    }
}
