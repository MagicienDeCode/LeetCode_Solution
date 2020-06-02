package list_array;

public class DeleteNodeinaLinkedList237 {
    public void deleteNode(ListNode node) {
        final ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
