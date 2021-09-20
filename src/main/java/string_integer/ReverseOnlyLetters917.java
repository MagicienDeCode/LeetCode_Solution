package string_integer;

public class ReverseOnlyLetters917 {
    public String reverseOnlyLetters(String s) {
        final StringBuilder sb = new StringBuilder();
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                while (!Character.isLetter(s.charAt(j))) {
                    --j;
                }
                sb.append(s.charAt(j--));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
