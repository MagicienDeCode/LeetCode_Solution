package breadth_first_search;

import java.util.*;

public class OpentheLock752 {
    private final Map<Character, char[]> mapNext = Map.of(
            '0', new char[]{'1', '9'},
            '1', new char[]{'2', '0'},
            '2', new char[]{'3', '1'},
            '3', new char[]{'4', '2'},
            '4', new char[]{'5', '3'},
            '5', new char[]{'6', '4'},
            '6', new char[]{'7', '5'},
            '7', new char[]{'8', '6'},
            '8', new char[]{'9', '7'},
            '9', new char[]{'0', '8'}
    );

    public int openLock(String[] deadEnds, String target) {
        final Set<String> deadEndsSet = new HashSet<>();
        Collections.addAll(deadEndsSet, deadEnds);
        if (deadEndsSet.contains("0000")) {
            return -1;
        }
        final List<String> targetNextList = new ArrayList<>();
        for (int index = 0; index < 4; index++) {
            final StringBuilder new1 = new StringBuilder(target);
            new1.setCharAt(index, mapNext.get(target.charAt(index))[0]);
            final StringBuilder new2 = new StringBuilder(target);
            new2.setCharAt(index, mapNext.get(target.charAt(index))[1]);
            targetNextList.add(new1.toString());
            targetNextList.add(new2.toString());
        }
        if (deadEndsSet.size() >= 8) {
            boolean flag = true;
            for (String targetNext : targetNextList) {
                flag = flag && deadEndsSet.contains(targetNext);
            }
            if (flag) {
                return -1;
            }
        }
        final Set<String> visited = new HashSet<>();
        final Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int result = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final String current = queue.poll();
                if (current.equals(target)) {
                    return result;
                }
                for (int index = 0; index < 4; index++) {
                    final StringBuilder new1 = new StringBuilder(current);
                    new1.setCharAt(index, mapNext.get(current.charAt(index))[0]);
                    final StringBuilder new2 = new StringBuilder(current);
                    new2.setCharAt(index, mapNext.get(current.charAt(index))[1]);
                    final List<String> news = List.of(new1.toString(), new2.toString());
                    news.forEach(it -> {
                        if (!visited.contains(it) && !deadEndsSet.contains(it)) {
                            queue.offer(it);
                            visited.add(it);
                        }
                    });
                }

            }
            ++result;
        }
        return -1;
    }
}
