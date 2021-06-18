package easy_easy;

import java.util.*;

public class GroupsofSpecialEquivalentStrings893 {
    public int numSpecialEquivGroups(String[] words) {
        final Set<String> set = new HashSet<>();
        for (String w : words) {
            set.add(construct(w));
        }
        return set.size();
    }

    private String construct(String w) {
        final List<Character> odds = new ArrayList<>();
        final List<Character> evens = new ArrayList<>();
        for (int i = 0; i < w.length(); i++) {
            if (i % 2 == 0) {
                evens.add(w.charAt(i));
            } else {
                odds.add(w.charAt(i));
            }
        }
        Collections.sort(odds);
        Collections.sort(evens);
        final StringBuilder sb = new StringBuilder();
        for (char c : odds) {
            sb.append(c);
        }
        for (char c : evens) {
            sb.append(c);
        }
        return sb.toString();
    }
    /*
    public int numSpecialEquivGroups(String[] words) {
        final boolean[] dp = new boolean[words.length];
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (dp[i]) {
                continue;
            }
            for (int j = i + 1; j < words.length; j++) {
                if (!dp[j] && isSameGroup(words[i], words[j])) {
                    dp[j] = true;
                }
            }
            dp[i] = true;
            ++count;
        }
        return count;
    }

    private boolean isSameGroup(String w1, String w2) {
        final int[] oddHash = new int[26];
        final int[] evenHash = new int[26];
        for (int i = 0; i < w1.length(); i++) {
            if (i % 2 == 0) {
                evenHash[w1.charAt(i) - 'a']++;
                evenHash[w2.charAt(i) - 'a']--;
            } else {
                oddHash[w1.charAt(i) - 'a']++;
                oddHash[w2.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (oddHash[i] != 0 || evenHash[i] != 0) {
                return false;
            }
        }
        return true;
    }
     */
}
