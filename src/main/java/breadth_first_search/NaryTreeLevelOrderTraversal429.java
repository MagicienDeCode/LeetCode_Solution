package breadth_first_search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal429 {

    public List<List<Integer>> levelOrder(Node root) {
        final List<List<Integer>> results = new LinkedList();
        if (root == null) {
            return results;
        }
        final Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            final List<Integer> levelResults = new LinkedList();
            for (int size = 0; size < currentSize; size++) {
                final Node currentNode = queue.poll();
                levelResults.add(currentNode.val);
                for (Node node : currentNode.children) {
                    queue.offer(node);
                }
            }
            results.add(levelResults);
        }
        return results;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val1) {
            val = val1;
        }

        public Node(int val1, List<Node> children1) {
            val = val1;
            children = children1;
        }
    }
}
