package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PathInZigzagLabelledBinaryTree1104 {
    public List<Integer> pathInZigZagTree(int label) {
        final Stack<Integer> stack = new Stack<>();
        int level = 0;
        int current = 2;
        while (current - 1 < label) {
            current <<= 1;
            ++level;
        }
        int trueVal;
        int zigzagVal = label;
        if (level % 2 == 0) {
            trueVal = label;
        } else {
            trueVal = calculateTrueValFromZigzag(label, level);
        }
        stack.push(zigzagVal);
        while (level > 0) {
            --level;
            trueVal >>= 1;
            zigzagVal = calculateZigZagValFromTrue(trueVal, level);
            stack.push(zigzagVal);
        }


        final List<Integer> results = new LinkedList<>();
        while (!stack.isEmpty()) {
            results.add(stack.pop());
        }
        return results;
    }

    private int calculateZigZagValFromTrue(int trueVal, int level) {
        if (level % 2 == 0) {
            return trueVal;
        } else {
            int min = 1 << level;
            int max = (1 << (level + 1)) - 1;
            return max - (trueVal - min);
        }
    }

    private int calculateTrueValFromZigzag(int zigzagVal, int level) {
        if (level % 2 == 0) {
            return zigzagVal;
        } else {
            int min = 1 << level;
            int max = (1 << (level + 1)) - 1;
            return min + (max - zigzagVal);
        }
    }
}
