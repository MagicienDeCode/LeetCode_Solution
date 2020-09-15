package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBST449 {
    private static final String DELIMITER = ",";
    private static final String NULL_NODE = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final StringBuilder results = new StringBuilder();
        preorder(root, results);
        return results.substring(0, results.length() - 1);
    }

    private void preorder(TreeNode root, StringBuilder results) {
        if (root == null) {
            results.append(NULL_NODE).append(DELIMITER);
        } else {
            results.append(root.val).append(DELIMITER);
            preorder(root.left, results);
            preorder(root.right, results);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        final Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, data.split(DELIMITER));
        return preorderBuilder(queue);
    }

    private TreeNode preorderBuilder(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        final String current = queue.poll();
        if (current.equals(NULL_NODE)) {
            return null;
        }
        final TreeNode root = new TreeNode(Integer.parseInt(current));
        root.left = preorderBuilder(queue);
        root.right = preorderBuilder(queue);
        return root;
    }
}
