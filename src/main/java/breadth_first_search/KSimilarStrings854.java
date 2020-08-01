package breadth_first_search;

import java.util.*;

public class KSimilarStrings854 {
    public int kSimilarity(String a, String b) {
        final Set<String> visited = new HashSet<>();
        final Queue<String> queue = new LinkedList<>();
        queue.offer(a);
        visited.add(a);
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final String current = queue.poll();
                if (current.equals(b)) {
                    return level;
                }
                for (String next : getNexts(current, b)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            ++level;
        }
        return -1;
    }

    private List<String> getNexts(String current, String target) {
        final List<String> results = new ArrayList<>();
        int i = 0;
        while (i < target.length() &&
                current.charAt(i) == target.charAt(i)) {
            ++i;
        }
        for (int j = i + 1; j < target.length(); j++) {
            if (target.charAt(j) == current.charAt(i)) {
                final StringBuilder newSb = new StringBuilder(current);
                final char temp = current.charAt(i);
                newSb.setCharAt(i, current.charAt(j));
                newSb.setCharAt(j, temp);
                results.add(newSb.toString());
            }
        }
        return results;
    }
}
