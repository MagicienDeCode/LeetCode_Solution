package list_array;

public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode second = reverse(slow.next);

        slow.next = null;
        // F 1 -> 2 -> 3
        // S 6 -> 5 -> 4
        /*
        f = 1
        s = 6

        1.next = 6
        6.next = 2

        s = 5
        f = 2
         */
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;

            second = secondNext;
            first = firstNext;
        }
    }

    private ListNode reverse(ListNode node) {
        // 5 -> 6 -> 7
        /*
        node = 5
        next = 6
        5.next = null
        prev = 5

        node = 6
        next = 7
        6.next = 5
        prev = 6

        node = 7
         */
        ListNode prev = null;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
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


