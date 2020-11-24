package depth_first_search;

public class ConvertSortedListtoBinarySearchTree109 {

    private ListNode head;

    private int count(final ListNode root) {
        ListNode current = root;
        int count = 0;
        while (current != null) {
            current = current.next;
            ++count;
        }
        return count;
    }

    public TreeNode sortedListToBST(ListNode head) {
        final int size = count(head);
        this.head = head;
        return dfs(0, size - 1);
    }

    private TreeNode dfs(int start, int end) {
        if (start > end) {
            return null;
        }
        final int mid = start + (end - start) / 2;
        final TreeNode left = dfs(start, mid - 1);
        final TreeNode node = new TreeNode(head.val);
        head = head.next;
        final TreeNode right = dfs(mid + 1, end);
        node.left = left;
        node.right = right;
        return node;
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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
