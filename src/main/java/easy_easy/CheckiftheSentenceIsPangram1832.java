package easy_easy;

public class CheckiftheSentenceIsPangram1832 {
    public boolean checkIfPangram(String sentence) {
        final boolean[] letters = new boolean[26];
        for (char c : sentence.toCharArray()) {
            letters[c - 'a'] = true;
        }
        boolean result = true;
        for (boolean l : letters) {
            result &= l;
        }
        return result;
    }
}
