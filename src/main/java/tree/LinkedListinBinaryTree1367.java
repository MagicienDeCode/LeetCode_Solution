package tree;

import java.util.LinkedList;
import java.util.List;

public class LinkedListinBinaryTree1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        final List<TreeNode> nodes = new LinkedList<>();
        dfs(root, nodes, head.val);
        for (TreeNode treeNode : nodes) {
            ListNode current = head;
            if (check(treeNode, current)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(TreeNode treeNode, ListNode current) {
        if (current == null) {
            return true;
        }
        if (treeNode == null) {
            return false;
        }
        return treeNode.val == current.val && (
                check(treeNode.left, current.next) ||
                        check(treeNode.right, current.next)
        );
    }

    private void dfs(TreeNode root, List<TreeNode> nodes, int target) {
        if (root == null) {
            return;
        }
        if (root.val == target) {
            nodes.add(root);
        }
        dfs(root.left, nodes, target);
        dfs(root.right, nodes, target);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
