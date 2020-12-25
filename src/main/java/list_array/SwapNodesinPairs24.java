package list_array;

public class SwapNodesinPairs24 {
    public ListNode swapPairs(ListNode head) {
        final ListNode preHead = new ListNode();
        preHead.next = head;

        ListNode current = preHead;
        while (current.next != null && current.next.next != null) {
            final ListNode first = current.next;
            final ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            second.next = first;
            current = first;
        }
        return preHead.next;
    }

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
