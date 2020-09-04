package string_integer;

import java.util.LinkedList;
import java.util.List;

public class PartitionLabels763 {
    public List<Integer> partitionLabels(String s) {
        final int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int end = 0;
        int start = 0;
        final List<Integer> results = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                results.add(end - start + 1);
                start = i + 1;
            }
        }
        return results;
    }
}
