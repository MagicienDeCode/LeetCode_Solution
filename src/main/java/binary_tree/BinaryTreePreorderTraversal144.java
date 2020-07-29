package binary_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> results = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                results.add(current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return results;
    }
    /*
    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> results = new LinkedList<>();

        if (root == null) {
            return results;
        }

        final List<Integer> leftResults = preorderTraversal(root.left);
        final List<Integer> rightResults = preorderTraversal(root.right);

        results.add(root.val);
        results.addAll(leftResults);
        results.addAll(rightResults);

        return results;
    }
     */
    /*
    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> results = new LinkedList<>();
        rootLeftRight(root, results);
        return results;
    }

    private void rootLeftRight(TreeNode root, List<Integer> results) {
        if (root == null){
            return;
        }
        results.add(root.val);
        rootLeftRight(root.left,results);
        rootLeftRight(root.right,results);
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
