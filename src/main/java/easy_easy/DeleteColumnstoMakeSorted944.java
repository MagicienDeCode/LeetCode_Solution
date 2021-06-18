package easy_easy;

import java.util.HashSet;
import java.util.Set;

public class DeleteColumnstoMakeSorted944 {
    public int minDeletionSize(String[] strs) {
        final char[] chars = new char[strs[0].length()];
        final Set<Integer> set = new HashSet<>();
        for (String s : strs) {
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(i)) {
                    continue;
                }
                if (chars[i] > s.charAt(i)) {
                    set.add(i);
                } else {
                    chars[i] = s.charAt(i);
                }
            }
        }
        return set.size();
    }
}
