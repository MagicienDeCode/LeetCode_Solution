package breadth_first_search;

import javafx.util.Pair;

import java.util.*;

public class WordLadderII126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        final List<List<String>> result = new LinkedList<>();
        final Map<String, Integer> wordMap = new HashMap<>();
        for (int index = 0; index < wordList.size(); index++) {
            wordMap.put(wordList.get(index), index);
        }
        if (!wordMap.containsKey(endWord)) {
            return result;
        }
        final Queue<Pair<String, String>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, ""));
        boolean flag = true;
        while (flag && !queue.isEmpty()) {
            final HashSet<String> currentLevelUsedWord = new HashSet<>();
            final int currentSize = queue.size();
            for (int k = 0; k < currentSize; k++) {
                final Pair<String, String> current = queue.poll();
                if (current.getKey().equals(endWord)) {
                    flag = false;
                    final List<String> r1 = new LinkedList<>();
                    r1.add(beginWord);
                    Arrays.stream(current.getValue().split(","))
                            .forEach(it ->
                                    r1.add(wordList.get(Integer.parseInt(it)))
                            );
                    result.add(r1);
                }
                if (flag) {
                    for (int index = 0; index < current.getKey().length(); index++) {
                        final StringBuilder str = new StringBuilder(current.getKey());
                        for (char c = 'a'; c <= 'z'; c++) {
                            str.setCharAt(index, c);
                            final String newStr = str.toString();
                            if (wordMap.containsKey(newStr) && !newStr.equals(current.getKey())) {
                                if (newStr.equals(endWord)) {
                                    queue.offer(new Pair<>(newStr,
                                            current.getValue() + wordMap.get(newStr)));
                                } else {
                                    currentLevelUsedWord.add(newStr);
                                    queue.offer(new Pair<>(newStr,
                                            current.getValue() + wordMap.get(newStr) + ","));
                                }
                            }
                        }
                    }
                }
            }
            currentLevelUsedWord.forEach(wordMap::remove);
        }
        return result;
    }
}
