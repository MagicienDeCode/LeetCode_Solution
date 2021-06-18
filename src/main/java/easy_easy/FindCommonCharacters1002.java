package easy_easy;

import java.util.LinkedList;
import java.util.List;

public class FindCommonCharacters1002 {
    public List<String> commonChars(String[] words) {
        final List<String> list = new LinkedList<>();
        final int[][] hash = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            final String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                hash[i][w.charAt(j) - 'a']++;
            }
        }
        for (char i = 'a'; i <= 'z'; i++) {
            int count = hash[0][i - 'a'];
            for (int j = 1; j < hash.length; j++) {
                count = Math.min(count, hash[j][i - 'a']);
            }
            for (int j = 0; j < count; j++) {
                list.add(String.valueOf(i));
            }
        }

        return list;
    }
}
