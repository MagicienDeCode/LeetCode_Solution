package stack;

import java.util.Stack;

public class RemoveDuplicateLetters316 {
    public String removeDuplicateLetters(String s) {
        //character frequency
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            //if already present in stack we dont need the character
            if (visited[c - 'a']) {
                continue;
            }

            //traverse through the stack and check for larger characters
            //if found and it is not the last position then pop from stack
            //Eg: bcabc => if stack has bc, now a<b and curr b is not the last one
            //if not in last position come out of loop and add curr character to stack
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                //make the current character available for next operations
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);

            visited[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
