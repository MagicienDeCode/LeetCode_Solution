package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindDuplicateSubtrees652 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        final HashMap<String, Integer> map = new HashMap<>();
        final List<TreeNode> results = new LinkedList<>();
        dfs(root, map, results);
        return results;
    }

    private String dfs(
            TreeNode node,
            HashMap<String, Integer> map,
            List<TreeNode> results) {
        if (node == null) {
            return "#";
        }
        final String current = node.val + "," +
                dfs(node.left, map, results) + "," +
                dfs(node.right, map, results);
        map.put(current, 1 + map.getOrDefault(current, 0));
        if (map.get(current) == 2) {
            results.add(node);
        }
        return current;
    }
}
