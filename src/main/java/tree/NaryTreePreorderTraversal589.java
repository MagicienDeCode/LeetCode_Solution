package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal589 {
    public List<Integer> preorder(Node root) {
        final List<Integer> results = new LinkedList<>();
        if (root == null) {
            return results;
        }

        final Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final Node current = stack.pop();
            results.add(current.val);
            for (int i = current.children.size() - 1; i >= 0; i--) {
                stack.push(current.children.get(i));
            }
        }
        return results;
    }
    /*
    public List<Integer> preorder(Node root) {
        final List<Integer> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        results.add(root.val);
        for (Node child : root.children) {
            results.addAll(preorder(child));
        }
        return results;
    }
     */

    // Definition for a Node.
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
