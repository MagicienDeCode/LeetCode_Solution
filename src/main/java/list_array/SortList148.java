package list_array;

public class SortList148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        final ListNode mid = middleNode(head);
        final ListNode left = sortList(head);
        final ListNode right = sortList(mid);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        final ListNode beforeHead = new ListNode();
        ListNode current = beforeHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        while (l1 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }
        while (l2 != null) {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }
        return beforeHead.next;
    }

    /*
    1 -> 2 -> 3 -> 4
    fast = 1, slow = null
    fast = 3, slow = 1
    fast = null, slow = 2
    result = 3
    2.next = null
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow == null ? head : slow.next;
        }
        final ListNode result = slow.next;
        slow.next = null;
        return result;
    }
}
