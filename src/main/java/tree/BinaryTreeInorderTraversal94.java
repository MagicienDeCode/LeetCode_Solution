package tree;

import java.util.LinkedList;
import java.util.List;

class BinaryTreeInorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> results = new LinkedList<>();

        if (root == null) {
            return results;
        }

        final List<Integer> leftResults = inorderTraversal(root.left);
        final List<Integer> rightResults = inorderTraversal(root.right);

        results.addAll(leftResults);
        results.add(root.val);
        results.addAll(rightResults);

        return results;
    }

    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> results = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            results.add(current.val);
            current = current.right;
        }
        return results;
    }
     */
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> results = new LinkedList<>();
        leftRootRight(root, results);
        return results;
    }

    private void leftRootRight(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        leftRootRight(root.left, results);
        results.add(root.val);
        leftRootRight(root.right, results);
    }
     */

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