package list_array;

public class ReverseNodesinkGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        final ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode beforeLeft = preHead;
        ListNode left = beforeLeft.next;
        ListNode right;
        ListNode afterRight;
        int count = 0;
        ListNode current = preHead;
        while (current.next != null) {
            current = current.next;
            count++;
            if (count == k) {
                right = current;
                afterRight = right.next;
                reverse(left);
                beforeLeft.next = right;
                left.next = afterRight;
                current = left;
                beforeLeft = current;
                left = beforeLeft.next;
                count = 0;
            }
        }
        return preHead;
    }

    private void reverse(ListNode start) {
        ListNode current = start;
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
