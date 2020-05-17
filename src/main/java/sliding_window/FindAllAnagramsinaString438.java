package sliding_window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllAnagramsinaString438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.equals("") || s.length() < p.length()) {
            return Collections.emptyList();
        }
        final List<Integer> result = new ArrayList<>();
        final int[] hashArray = new int[26];
        for (int index = 0; index < p.length(); index++) {
            ++hashArray[p.charAt(index) - 'a'];
        }
        int count = 0;
        int left = 0;
        for (int index = 0; index < s.length(); index++) {
            if (--hashArray[s.charAt(index) - 'a'] >= 0) {
                ++count;
            }
            if (index >= p.length() && hashArray[s.charAt(left++) - 'a']++ >= 0) {
                --count;
            }
            if (count == p.length()) {
                result.add(left);
            }
        }
        return result;
    }
    /*
    public List<Integer> findAnagrams(String s, String p) {
        if (s.equals("") || s.length() < p.length()) {
            return Collections.emptyList();
        }
        final List<Integer> result = new ArrayList<>();
        final int[] hashArray = new int[26];
        for (int index = 0; index < p.length(); index++) {
            ++hashArray[p.charAt(index) - 'a'];
            --hashArray[s.charAt(index) - 'a'];
        }
        if (Arrays.stream(hashArray).filter(it -> it == 0).count() == 26) {
            result.add(0);
        }
        for (int index = 1; index < s.length() - p.length() + 1; index++) {
            ++hashArray[s.charAt(index - 1) - 'a'];
            --hashArray[s.charAt(index + p.length() - 1) - 'a'];
            if (Arrays.stream(hashArray).filter(it -> it == 0).count() == 26) {
                result.add(index);
            }
        }
        return result;
    }
     */

    public static void main(String[] args) {
        final FindAllAnagramsinaString438 solution = new FindAllAnagramsinaString438();
        solution.findAnagrams("cbaebabacd", "abc");
    }
}
