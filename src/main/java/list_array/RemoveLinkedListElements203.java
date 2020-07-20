package list_array;

public class RemoveLinkedListElements203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        }
        head.next = removeElements(head.next, val);
        return head;
    }
    /*
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        while (current != null && current.val == val) {
            current = current.next;
        }
        final ListNode result = current;
        ListNode previous = current;
        if (current == null) {
            return null;
        }
        current = current.next;
        while (current != null) {
            if (current.val == val) {
                while (current != null && current.val == val) {
                    current = current.next;
                }
                previous.next = current;
                if (current == null) {
                    return result;
                }
            }
            previous = current;
            current = current.next;
        }
        return result;
    }
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
