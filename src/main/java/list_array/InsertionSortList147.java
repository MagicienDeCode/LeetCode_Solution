package list_array;

public class InsertionSortList147 {
    public ListNode insertionSortList(ListNode head) {
        final ListNode preNewHead = new ListNode();
        ListNode current = head;
        ListNode pre;
        ListNode next;
        while (current != null) {
            // each time reset pre,next
            pre = preNewHead;
            next = preNewHead.next;

            // find the insert position
            while (next != null) {
                if (current.val < next.val) {
                    break;
                }
                pre = pre.next;
                next = next.next;
            }

            // mark the next
            final ListNode nextToBeInsert = current.next;

            // insert
            pre.next = current;
            current.next = next;

            current = nextToBeInsert;
        }

        return preNewHead.next;
    }
}
