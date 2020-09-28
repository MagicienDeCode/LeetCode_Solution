package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        final int height = getHeight(root);
        
        return results;
    }

    private int getHeight(TreeNode root) {
        int level = 0;
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                final TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ++level;
        }
        return level;
    }


    public static void main(String[] args) {
        final TreeNode node1 = new TreeNode(1);
        final TreeNode node2 = new TreeNode(2);
        final TreeNode node3 = new TreeNode(3);
        final TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        final PrintBinaryTree655 java = new PrintBinaryTree655();
        final List<List<String>> result = java.printTree(node1);
        System.out.println(result);
    }
}
