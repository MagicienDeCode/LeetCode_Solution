package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindModeinBinarySearchTree501 {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        int preValue = Integer.MIN_VALUE;
        int max = 0;
        int count = 1;
        final List<Integer> results = new ArrayList<>();
        // inorder traversal using stack
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                // preorder add value here
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            // inorder add value here

            // compare with preValue
            if (preValue == current.val) {
                ++count;
            } else {
                count = 1;
            }

            // compare with max
            if (count > max) {
                max = count;
                results.clear();
                results.add(current.val);
            } else if (count == max) {
                results.add(current.val);
            }

            // reassign preValue
            preValue = current.val;

            current = current.right;
        }
        final int[] resultArray = new int[results.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = results.get(i);
        }
        return resultArray;
    }
    /*
    private int preValue = Integer.MIN_VALUE;
    private int max = 0;
    private int count = 1;

    public int[] findMode(TreeNode root) {
        final List<Integer> results = new ArrayList<>();
        leftRootRight(root, results);
        final int[] res = new int[results.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = results.get(i);
        }
        return res;
    }

    // inorder traversal
    private void leftRootRight(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        leftRootRight(root.left, results);

        // compare with preValue
        if (preValue == root.val) {
            ++count;
        } else {
            count = 1;
        }
        // compare with max
        if (count > max) {
            max = count;
            results.clear();
            results.add(root.val);
        } else if (count == max) {
            results.add(root.val);
        }
        // reassign preValue
        preValue = root.val;
        leftRootRight(root.right, results);
    }
     */
}
