package list_array;

public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {

        ListNode current = head;

        ListNode leftHead = new ListNode();
        ListNode left = leftHead;
        ListNode rightHead = new ListNode();
        ListNode right = rightHead;

        while (current != null) {
            if (current.val < x) {
                left.next = current;
                left = left.next;
            } else {
                right.next = current;
                right = right.next;
            }
            current = current.next;
        }

        left.next = rightHead.next;
        right.next = null;
        return leftHead.next;
    }
}
