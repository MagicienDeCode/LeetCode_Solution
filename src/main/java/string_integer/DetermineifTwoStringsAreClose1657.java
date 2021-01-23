package string_integer;

public class DetermineifTwoStringsAreClose1657 {
    public boolean closeStrings(String word1, String word2) {
        final int[] hash1 = new int[26];
        final int[] hash2 = new int[26];
        if (word1.length() != word2.length()) {
            return false;
        }
        for (int i = 0; i < word1.length(); i++) {
            hash1[word1.charAt(i) - 'a']++;
            hash2[word2.charAt(i) - 'a']++;
        }
        final int[] count1 = new int[word1.length() + 1];
        final int[] count2 = new int[word2.length() + 1];
        for (int i = 0; i < 26; i++) {
            if ((hash1[i] == 0 && hash2[i] > 0) || (hash1[i] > 0 && hash2[i] == 0)) {
                return false;
            }
            count1[hash1[i]]++;
            count2[hash2[i]]++;
        }
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final DetermineifTwoStringsAreClose1657 java = new DetermineifTwoStringsAreClose1657();
        // T F T F
        System.out.println(java.closeStrings("abc", "bca"));
        System.out.println(java.closeStrings("a", "aa"));
        System.out.println(java.closeStrings("cabbba", "abbccc"));
        System.out.println(java.closeStrings("cabbba", "aabbss"));
    }
}
