package string_integer;

import java.util.List;

public class LongestWordinDictionarythroughDeleting524 {
    public String findLongestWord(String s, List<String> d) {
        d.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return Integer.compare(s2.length(), s1.length());
        });
        for (String candidate : d) {
            if (candidate.length() > s.length()) {
                continue;
            }
            int cIndex = 0;
            for (int i = 0; i < s.length() && cIndex < candidate.length(); i++) {
                if (candidate.charAt(cIndex) == s.charAt(i)) {
                    cIndex++;
                }
            }
            if (cIndex == candidate.length()) {
                return candidate;
            }
        }
        return "";
    }
}
