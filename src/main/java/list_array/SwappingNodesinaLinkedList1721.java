package list_array;

public class SwappingNodesinaLinkedList1721 {
    public ListNode swapNodes(ListNode head, int k) {
        int total = 0;
        int count = k;
        final ListNode beforeHead = new ListNode();
        beforeHead.next = head;
        ListNode fast = beforeHead;
        ListNode slow = beforeHead;
        ListNode beforeStart;
        ListNode beforeEnd;
        while (count != 1) {
            fast = fast.next;
            count--;
        }
        beforeStart = fast;
        fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            total++;
        }

        if (total < k) {
            beforeEnd = beforeStart;
            beforeStart = slow;
        } else {
            beforeEnd = slow;
        }
        reverse(beforeStart, beforeStart.next, beforeEnd, beforeEnd.next);
        return beforeStart == beforeHead ? beforeStart.next : head;
    }

    private void reverse(ListNode beforeStart, ListNode start, ListNode beforeEnd, ListNode end) {
        if (start == beforeEnd) {
            start.next = end.next;
            end.next = start;
            beforeStart.next = end;
        } else {
            final ListNode afterStart = start.next;
            start.next = end.next;
            beforeEnd.next = start;
            end.next = afterStart;
            beforeStart.next = end;
        }
    }
}
