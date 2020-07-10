package list_array;

public class FlattenaMultilevelDoublyLinkedList430 {

    public Node flatten(Node head) {
        Node current = head;
        while (current != null) {
            if (current.child != null) {
                final Node next = current.next;
                Node lastChild = current.child;
                while (lastChild.next != null) {
                    lastChild = lastChild.next;
                }
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
                lastChild.next = next;
                if (next != null) {
                    next.prev = lastChild;
                }
            }
            current = current.next;
        }
        return head;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
