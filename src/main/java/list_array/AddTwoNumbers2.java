package list_array;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode preHead = new ListNode();
        ListNode current = preHead;
        ListNode a1 = l1;
        ListNode b2 = l2;
        int plus = 0;
        while (a1 != null || b2 != null) {
            final int x = a1 == null ? 0 : a1.val;
            final int y = b2 == null ? 0 : b2.val;
            final int sum = x + y + plus;
            plus = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (a1 != null) {
                a1 = a1.next;
            }
            if (b2 != null) {
                b2 = b2.next;
            }
        }
        if (plus != 0) {
            current.next = new ListNode(plus);
        }
        return preHead.next;
    }
}
