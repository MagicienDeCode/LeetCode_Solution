package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII117 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        final Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            Node previous = null;
            for (int size = 0; size < currentSize; size++) {
                final Node current = queue.poll();
                if (previous != null) {
                    previous.next = current;
                }
                previous = current;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
