package tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        final List<Integer> leaf1 = new ArrayList<>();
        final List<Integer> leaf2 = new ArrayList<>();
        inorder(root1, leaf1);
        inorder(root2, leaf2);
        if (leaf1.size() != leaf2.size()) {
            return false;
        }
        for (int i = 0; i < leaf1.size(); i++) {
            if (!leaf1.get(i).equals(leaf2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode node, List<Integer> leaf) {
        if (node == null) {
            return;
        }
        inorder(node.left, leaf);
        if (node.left == null && node.right == null) {
            leaf.add(node.val);
        }
        inorder(node.right, leaf);
    }
}
