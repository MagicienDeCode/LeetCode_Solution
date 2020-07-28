package string_integer;

import java.util.Arrays;

public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        final int[] chars = new int[26];
        for (char c : tasks) {
            ++chars[c - 'A'];
        }
        Arrays.sort(chars);
        int index = 25;
        while (index >= 0 && chars[index] == chars[25]) {
            --index;
        }
        final int result = (chars[25] - 1) * (n + 1) + 25 - index;
        return Math.max(tasks.length, result);
    }
}
