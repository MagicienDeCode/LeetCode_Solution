package list_array;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        final Map<Node, Node> map = new HashMap<>();
        final Node preNewHead = new Node(-1);
        Node original = head;
        Node copy = preNewHead;
        while (original != null) {
            copy.next = new Node(original.val);
            copy = copy.next;
            map.put(original, copy);
            original = original.next;
        }
        original = head;
        while (original != null) {
            if (original.random != null) {
                final Node currentCopy = map.get(original);
                currentCopy.random = map.get(original.random);
            }
            original = original.next;
        }
        return preNewHead.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
