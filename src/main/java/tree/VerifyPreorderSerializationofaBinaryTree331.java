package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class VerifyPreorderSerializationofaBinaryTree331 {
    private static final String DELIMITER = ",";
    private static final String NULL_NODE = "#";

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        final Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, preorder.split(DELIMITER));
        final boolean result = preorderBuilder(queue);
        return result && queue.isEmpty();
    }

    private boolean preorderBuilder(Queue<String> queue) {
        if (queue.isEmpty()) {
            return false;
        }
        final String current = queue.poll();
        if (current.equals(NULL_NODE)) {
            return true;
        }
        final boolean leftResult = preorderBuilder(queue);
        final boolean rightResult = preorderBuilder(queue);
        return leftResult && rightResult;
    }
}
