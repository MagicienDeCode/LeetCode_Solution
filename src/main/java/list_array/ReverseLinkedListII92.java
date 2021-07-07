package list_array;

public class ReverseLinkedListII92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        final ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode current = preHead;
        int count = 1;
        while (count != left) {
            current = current.next;
            count++;
        }
        final ListNode preLeft = current;
        final ListNode leftNode = current.next;
        while (count != right + 1) {
            current = current.next;
            ++count;
        }
        final ListNode rightNode = current;
        final ListNode nextRight = current.next;
        rightNode.next = null;
        reverse(leftNode);
        preLeft.next = rightNode;
        leftNode.next = nextRight;
        return preHead.next;
    }

    private void reverse(ListNode leftNode) {
        ListNode current = leftNode;
        ListNode before = null;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = before;
            before = current;
            current = next;
        }
    }
}
