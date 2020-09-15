package string_integer;

public class LengthofLastWord58 {

    public int lengthOfLastWord(String s) {
        final String[] strings = s.split(" ");
        if (strings.length == 0) {
            return 0;
        }
        return strings[strings.length - 1].length();
    }

    /*
    public int lengthOfLastWord(String s) {
        int result = 0;
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            --index;
        }
        while (index >= 0 && s.charAt(index) != ' ') {
            ++result;
            --index;
        }
        return result;
    }
    */
}
