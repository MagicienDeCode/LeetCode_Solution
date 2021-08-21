package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        final Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        final int required = target.size();

        final Map<Character, Integer> current = new HashMap<>();

        int left = 0;
        int right = 0;
        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            current.put(c, current.getOrDefault(c, 0) + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (target.containsKey(c) && current.get(c).intValue() == target.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (left <= right && formed == required) {
                c = s.charAt(left);
                // Save the smallest window until now.
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                current.put(c, current.get(c) - 1);
                if (target.containsKey(c) && current.get(c) < target.get(c)) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                left++;
            }

            // Keep expanding the window once we are done contracting.
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
