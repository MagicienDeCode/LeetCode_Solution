package list_array;

public class OddEvenLinkedList328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        final ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;
        ListNode current = even;
        int count = 0;
        while (current.next != null) {
            current = current.next;
            if (count % 2 == 0) {
                odd.next = current;
                odd = current;
            } else {
                even.next = current;
                even = current;
            }
            count++;
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }

    class ListNode {
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
