package hash_map_set;

import java.util.TreeSet;

public class NumberofMatchingSubsequences792 {
    public int numMatchingSubseq(String s, String[] words) {
        final TreeSet<Integer>[] treeSets = new TreeSet[26];
        for (int i = 0; i < 26; i++) {
            treeSets[i] = new TreeSet<>();
        }
        for (int i = 0; i < s.length(); i++) {
            final int index = s.charAt(i) - 'a';
            treeSets[index].add(i);
        }
        int count = 0;
        for (String word : words) {
            int currentIndex = -1;
            for (int i = 0; i < word.length(); i++) {
                final Integer currentCharIndex = treeSets[word.charAt(i) - 'a'].higher(currentIndex);
                if (currentCharIndex != null && currentCharIndex > currentIndex) {
                    currentIndex = currentCharIndex;
                } else {
                    currentIndex = -1;
                    break;
                }
            }
            count += currentIndex == -1 ? 0 : 1;
        }
        return count;
    }
}
