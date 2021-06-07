package easy_easy;

public class CheckifWordEqualsSummationofTwoWords1880 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return transform(targetWord) == transform(firstWord) + transform(secondWord);
    }

    private int transform(String word) {
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            final int current = word.charAt(i) - 'a';
            result = result * 10 + current;
        }
        return result;
    }
}
