package list_array;

public class RemoveDuplicatesfromSortedListII82 {
    public ListNode deleteDuplicates(ListNode head) {
        final ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode current = preHead;
        while (current != null) {
            ListNode afterLastDuplicateNode = current.next;
            while (afterLastDuplicateNode != null && afterLastDuplicateNode.next != null &&
                    afterLastDuplicateNode.val == afterLastDuplicateNode.next.val) {
                ListNode afterLastSameNode = afterLastDuplicateNode.next;
                while (afterLastSameNode != null && afterLastDuplicateNode.val == afterLastSameNode.val) {
                    afterLastSameNode = afterLastSameNode.next;
                }
                afterLastDuplicateNode = afterLastSameNode;
            }
            current = current.next;
        }
        return preHead.next;
    }
}
