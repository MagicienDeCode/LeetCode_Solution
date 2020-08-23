package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> results = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                results.add(0, current.val);
                current = current.right;
            }
            current = stack.pop().left;
        }
        return results;
    }
    /*
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> results = new LinkedList<>();
        leftRightRoot(root, results);
        return results;
    }

    private void leftRightRoot(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        leftRightRoot(root.left, results);
        leftRightRoot(root.right, results);
        results.add(root.val);
    }
     */
    /*
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> results = new LinkedList<>();

        if (root == null) {
            return results;
        }

        final List<Integer> leftResults = postorderTraversal(root.left);
        final List<Integer> rightResults = postorderTraversal(root.right);

        results.addAll(leftResults);
        results.addAll(rightResults);
        results.add(root.val);

        return results;
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
