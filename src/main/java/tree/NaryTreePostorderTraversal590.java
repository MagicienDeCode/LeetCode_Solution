package tree;

import java.util.LinkedList;
import java.util.List;

public class NaryTreePostorderTraversal590 {

    public List<Integer> postorder(Node root) {
        final List<Integer> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        for (Node child : root.children) {
            results.addAll(postorder(child));
        }
        results.add(root.val);
        return results;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
