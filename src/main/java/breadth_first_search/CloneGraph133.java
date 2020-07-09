package breadth_first_search;

import java.util.*;

class CloneGraph133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        final Map<Node, Node> oldToNewMap = new HashMap();

        // bfs get all nodes
        final List<Node> allNodes = bfs(node);

        // copy all nodes
        for (Node oldNode : allNodes) {
            final Node newNode = new Node(oldNode.val);
            oldToNewMap.put(oldNode, newNode);
        }

        // cope neighbors
        for (Node oldNode : allNodes) {
            final List<Node> neighbors = oldNode.neighbors;
            final Node newNode = oldToNewMap.get(oldNode);
            for (Node neighbor : neighbors) {
                newNode.neighbors.add(oldToNewMap.get(neighbor));
            }
        }

        return oldToNewMap.get(node);
    }

    private List<Node> bfs(final Node node) {
        final Set<Node> set = new HashSet();
        final Queue<Node> queue = new LinkedList();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            final Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return new ArrayList(set);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int value) {
            val = value;
            neighbors = new ArrayList<Node>();
        }

        public Node(int value, ArrayList<Node> neighborsValue) {
            val = value;
            neighbors = neighborsValue;
        }
    }
}