package list_array;

import java.util.LinkedList;
import java.util.List;

public class WordSubsets916 {
    public List<String> wordSubsets(String[] aArray, String[] bArray) {
        final int[] bCount = new int[26];
        for (String b : bArray) {
            countBmax(b, bCount);
        }
        final List<String> result = new LinkedList<>();
        for (String a : aArray) {
            if (compare(a, bCount)) {
                result.add(a);
            }
        }
        return result;
    }

    private void countBmax(String b, int[] bCount) {
        final int[] temp = new int[26];
        for (char c : b.toCharArray()) {
            temp[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            bCount[i] = Math.max(bCount[i], temp[i]);
        }
    }

    private boolean compare(String a, int[] bCount) {
        final int[] aCount = new int[26];
        for (char c : a.toCharArray()) {
            aCount[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (bCount[i] > aCount[i]) {
                return false;
            }
        }
        return true;
    }
}
