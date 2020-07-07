package breadth_first_search;

import java.util.*;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        int count = 1;
        final Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int k = 0; k < currentSize; k++) {
                final String currentString = queue.poll();
                if (currentString.equals(endWord)) {
                    return count;
                }
                for (int index = 0; index < currentString.length(); index++) {
                    final StringBuilder str = new StringBuilder(currentString);
                    for (char c = 'a'; c <= 'z'; c++) {
                        str.setCharAt(index, c);
                        final String newStr = str.toString();
                        if (wordSet.contains(newStr) && !newStr.equals(currentString)) {
                            queue.offer(newStr);
                            wordSet.remove(newStr);
                        }
                    }
                }
            }
            ++count;
        }
        return 0;
    }
}
