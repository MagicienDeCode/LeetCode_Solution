package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter919 {

    private final TreeNode root;
    private final Queue<TreeNode> parents = new LinkedList<>();

    public CompleteBinaryTreeInserter919(TreeNode root) {
        this.root = root;
        // bfs add the last level nodes into parents
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final TreeNode current = queue.poll();
            if (current.left == null || current.right == null) {
                parents.offer(current);
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public int insert(int v) {
        final TreeNode current = new TreeNode(v);
        parents.offer(current);
        final TreeNode parent = parents.peek();
        if (parent.left == null) {
            parent.left = current;
        } else {
            parent.right = current;
            parents.poll();
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
