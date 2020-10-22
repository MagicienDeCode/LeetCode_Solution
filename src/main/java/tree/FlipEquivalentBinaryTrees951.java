package tree;

import java.util.ArrayList;
import java.util.List;

public class FlipEquivalentBinaryTrees951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        final List<Integer> results1 = new ArrayList<>();
        final List<Integer> results2 = new ArrayList<>();
        traversal(root1, results1);
        traversal(root2, results2);
        return results1.equals(results2);
    }

    private void traversal(TreeNode node, List<Integer> results) {
        if (node == null) {
            results.add(null);
            return;
        }
        results.add(node.val);
        final int left = node.left == null ? -1 : node.left.val;
        final int right = node.right == null ? -1 : node.right.val;
        if (left < right) {
            traversal(node.left, results);
            traversal(node.right, results);
        } else {
            traversal(node.right, results);
            traversal(node.left, results);
        }
    }


    /*
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
     */
}
