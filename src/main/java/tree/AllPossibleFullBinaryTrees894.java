package tree;

import java.util.*;

public class AllPossibleFullBinaryTrees894 {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 1) {
            return List.of(new TreeNode(0));
        }
        if (n < 3 || n % 2 == 0) {
            return Collections.emptyList();
        }
        final Map<Integer, List<TreeNode>> map = new HashMap();
        map.put(1, List.of(new TreeNode(0)));
        for (int i = 3; i <= n; i += 2) {
            buildTree(map, i);
        }
        return map.get(n);
    }

    private void buildTree(Map<Integer, List<TreeNode>> map, int i) {
        final List<TreeNode> levelResults = new ArrayList<>();
        for (int left = 1; left < i; left += 2) {
            final int right = i - left - 1;
            for (TreeNode l : map.get(left)) {
                for (TreeNode r : map.get(right)) {
                    final TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    levelResults.add(root);
                }
            }
        }
        map.put(i, levelResults);
    }

    public static void main(String[] args) {
        final AllPossibleFullBinaryTrees894 java = new AllPossibleFullBinaryTrees894();
        final List<TreeNode> results = java.allPossibleFBT(7);
        System.out.println(results);
    }
}
