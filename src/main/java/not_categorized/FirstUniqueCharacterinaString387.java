package not_categorized;

public class FirstUniqueCharacterinaString387 {
    public int firstUniqChar(String s) {
        int result = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            final int index = s.indexOf(c);
            if (index != -1 && s.lastIndexOf(c) == index) {
                result = Math.min(result, index);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    /*
    public int firstUniqChar(String s) {
        final int[] intArray = new int[26];
        for (int index = 0; index < s.length(); index++) {
            intArray[s.charAt(index) - 'a']++;
        }
        for (int index = 0; index < s.length(); index++) {
            if (intArray[s.charAt(index) - 'a'] == 1) {
                return index;
            }
        }
        return -1;
    }
     */
}
