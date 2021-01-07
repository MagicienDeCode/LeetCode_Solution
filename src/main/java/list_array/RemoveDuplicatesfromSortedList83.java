package list_array;

public class RemoveDuplicatesfromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode afterLastSameNode = current.next;
            while (afterLastSameNode != null && current.val == afterLastSameNode.val) {
                afterLastSameNode = afterLastSameNode.next;
            }
            current.next = afterLastSameNode;
            current = current.next;
        }
        return head;
    }
}
