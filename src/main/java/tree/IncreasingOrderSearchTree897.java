package tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree897 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        final List<TreeNode> allNodes = new ArrayList<>();
        inorder(root, allNodes);
        for (int i = 0; i < allNodes.size() - 1; i++) {
            final TreeNode parent = allNodes.get(i);
            final TreeNode child = allNodes.get(i + 1);
            parent.left = null;
            parent.right = child;
        }
        final TreeNode lastNode = allNodes.get(allNodes.size() - 1);
        lastNode.right = null;
        lastNode.left = null;
        return allNodes.get(0);
    }

    private void inorder(TreeNode root, List<TreeNode> allNodes) {
        if (root == null) {
            return;
        }
        inorder(root.left, allNodes);
        allNodes.add(root);
        inorder(root.right, allNodes);
    }
}
