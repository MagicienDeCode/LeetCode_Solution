package stack;

import java.util.Stack;

public class ValidateStackSequences946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        final Stack<Integer> stack = new Stack<>();
        int ipush = 0;
        int ipop = 0;
        while (ipush != pushed.length) {
            while (!stack.isEmpty() && stack.peek() == popped[ipop]) {
                stack.pop();
                ++ipop;
            }
            stack.push(pushed[ipush++]);
        }
        while (!stack.isEmpty() && stack.peek() == popped[ipop]) {
            stack.pop();
            ++ipop;
        }
        return ipop == ipush;
    }
}
