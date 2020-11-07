package list_array;

import java.util.Stack;

public class AddTwoNumbersII445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = null;
        final Stack<ListNode> s1 = new Stack<>();
        final Stack<ListNode> s2 = new Stack<>();
        ListNode a1 = l1;
        ListNode b2 = l2;
        while (a1 != null) {
            s1.push(a1);
            a1 = a1.next;
        }
        while (b2 != null) {
            s2.push(b2);
            b2 = b2.next;
        }
        int plus = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            final int x = s1.isEmpty() ? 0 : s1.pop().val;
            final int y = s2.isEmpty() ? 0 : s2.pop().val;
            final int sum = x + y + plus;
            plus = sum / 10;
            final ListNode pre = new ListNode(sum % 10);
            pre.next = current;
            current = pre;
        }
        if (plus != 0) {
            final ListNode pre = new ListNode(plus);
            pre.next = current;
            return pre;
        } else {
            return current;
        }
    }
}
