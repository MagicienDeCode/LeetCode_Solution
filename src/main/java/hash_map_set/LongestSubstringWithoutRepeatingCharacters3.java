package hash_map_set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int left = 0;
        int result = 1;
        final int[] hash = new int[128];
        for (int right = 0; right < s.length(); right++) {
            final char c = s.charAt(right);
            left = Math.max(left, hash[c]);
            result = Math.max(result, right - left + 1);
            hash[c] = right + 1;
        }
        return result;
    }
    /*
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int left = 0;
        int result = 1;
        final Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            final char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            result = Math.max(result, right - left + 1);
            map.put(c, right);
        }
        return result;
    }
     */
}
