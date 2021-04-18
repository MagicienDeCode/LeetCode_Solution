package list_array;

public class RemoveNthNodeFromEndofList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        final ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode fast = preHead;
        ListNode slow = preHead;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return preHead.next;
    }
}
