package string_integer;

public class CustomSortString791 {
    public String customSortString(String order, String str) {
        final int[] hash = new int[26];
        for (char c : str.toCharArray()) {
            hash[c - 'a']++;
        }
        final StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (hash[c - 'a'] > 0) {
                sb.append(String.valueOf(c).repeat(hash[c - 'a']));
                hash[c - 'a'] = 0;
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (hash[c - 'a'] > 0) {
                sb.append(String.valueOf(c).repeat(hash[c - 'a']));
            }
        }
        return sb.toString();
    }
}
