package string_integer;

public class RepeatedSubstringPattern459 {
    public boolean repeatedSubstringPattern(String s) {
        return s.repeat(2).substring(1, s.length() * 2 - 1).contains(s);
    }
}
