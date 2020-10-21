package stack;

import java.util.Stack;

public class AsteroidCollision735 {
    public int[] asteroidCollision(int[] asteroids) {
        final Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            check(asteroid, stack);
        }
        final int[] resultArray = new int[stack.size()];
        for (int i = resultArray.length - 1; i >= 0; i--) {
            resultArray[i] = stack.pop();
        }
        return resultArray;
    }

    private void check(int asteroid, Stack<Integer> stack) {
        while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
            if (stack.peek() < -asteroid) {
                stack.pop();
                continue;
            }
            if (stack.peek() == -asteroid) {
                stack.pop();
            }
            return;
        }
        stack.push(asteroid);
    }
}
