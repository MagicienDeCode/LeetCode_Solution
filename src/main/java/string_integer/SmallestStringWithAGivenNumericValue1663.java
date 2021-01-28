package string_integer;

public class SmallestStringWithAGivenNumericValue1663 {
    public String getSmallestString(int n, int k) {
        final StringBuilder result = new StringBuilder("a".repeat(n));
        int remain = k - n;
        int index = n - 1;
        while (remain > 0) {
            if (remain >= 25) {
                remain -= 25;
                result.setCharAt(index--, 'z');
            } else {
                result.setCharAt(index, (char) ('a' + remain));
                remain = 0;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        final SmallestStringWithAGivenNumericValue1663 java = new SmallestStringWithAGivenNumericValue1663();
        // aayzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
        System.out.println(java.getSmallestString(85, 2156));
        // zzzzz
        System.out.println(java.getSmallestString(5, 130));
        // aay
        System.out.println(java.getSmallestString(3, 27));
        // aaszz
        System.out.println(java.getSmallestString(5, 73));
        // aaaz
        System.out.println(java.getSmallestString(4, 29));
        System.out.println(java.getSmallestString(4, 30));
        System.out.println(java.getSmallestString(4, 28));
    }
}
