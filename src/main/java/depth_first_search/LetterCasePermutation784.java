package depth_first_search;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation784 {
    public List<String> letterCasePermutation(String s) {
        final List<String> results = new LinkedList<>();
        dfs(s.toCharArray(), 0, results, new StringBuilder());
        return results;
    }

    private void dfs(char[] charArray, int currentIndex, List<String> results, StringBuilder stringBuilder) {
        if (currentIndex == charArray.length) {
            results.add(stringBuilder.toString());
        } else {
            if (Character.isLetter(charArray[currentIndex])) {
                stringBuilder.append(String.valueOf(charArray[currentIndex]).toLowerCase());
                dfs(charArray, currentIndex + 1, results, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.append(String.valueOf(charArray[currentIndex]).toUpperCase());
                dfs(charArray, currentIndex + 1, results, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else {
                stringBuilder.append(charArray[currentIndex]);
                dfs(charArray, currentIndex + 1, results, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
