package string_integer;

public class DetectCapital520 {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                ++count;
            }
        }
        if (count == 0) {
            return true;
        }
        if (count == word.length()) {
            return true;
        }
        return count == 1 && Character.isUpperCase(word.charAt(0));
    }
}
