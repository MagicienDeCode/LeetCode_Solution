package tree;

import java.util.ArrayList;
import java.util.List;

public class AllElementsinTwoBinarySearchTrees1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        final List<Integer> root1s = new ArrayList<>();
        final List<Integer> root2s = new ArrayList<>();
        inorder(root1, root1s);
        inorder(root2, root2s);
        final List<Integer> results = new ArrayList<>();
        merge(root1s, root2s, results);
        return results;
    }

    private void merge(List<Integer> root1s, List<Integer> root2s, List<Integer> results) {
        int i1 = 0;
        int i2 = 0;
        while (i1 < root1s.size() && i2 < root2s.size()) {
            final int r1 = root1s.get(i1);
            final int r2 = root2s.get(i2);
            if (r1 <= r2) {
                results.add(r1);
                ++i1;
            } else {
                results.add(r2);
                ++i2;
            }
        }
        while (i1 < root1s.size()) {
            results.add(root1s.get(i1++));
        }
        while (i2 < root2s.size()) {
            results.add(root2s.get(i2++));
        }
    }

    private void inorder(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        inorder(root.left, results);
        results.add(root.val);
        inorder(root.right, results);
    }
}
