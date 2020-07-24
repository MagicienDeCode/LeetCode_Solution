package breadth_first_search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthofNaryTree559 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        final Queue<Node> queue = new LinkedList();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final Node currentNode = queue.poll();
                for (Node node : currentNode.children) {
                    queue.offer(node);
                }
            }
            ++level;
        }
        return level;
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
