package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack895 {

    private final Map<Integer, Integer> frequency = new HashMap<>();
    private final Map<Integer, Stack<Integer>> maxFrequency = new HashMap<>();
    int maxFreq = 0;

    public void push(int x) {
        final int currentF = frequency.getOrDefault(x, 0) + 1;
        frequency.put(x, currentF);
        if (currentF > maxFreq) {
            maxFreq = currentF;
        }
        maxFrequency.computeIfAbsent(currentF, v -> new Stack<>()).push(x);
    }

    public int pop() {
        final int result = maxFrequency.get(maxFreq).pop();
        frequency.put(result, frequency.get(result) - 1);
        if (maxFrequency.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return result;
    }
}
