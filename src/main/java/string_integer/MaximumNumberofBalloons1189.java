package string_integer;

public class MaximumNumberofBalloons1189 {
    public int maxNumberOfBalloons(String text) {
        // b a ll oo n
        // 0 1  2  3 4
        final int[] hash = new int[5];
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    hash[0]++;
                    break;
                case 'a':
                    hash[1]++;
                    break;
                case 'l':
                    hash[2]++;
                    break;
                case 'o':
                    hash[3]++;
                    break;
                case 'n':
                    hash[4]++;
                    break;
                default:
            }
        }
        int result = Integer.MAX_VALUE;
        hash[2] = hash[2] >> 1;
        hash[3] = hash[3] >> 1;
        for (int i = 0; i < 5; i++) {
            result = Math.min(result, hash[i]);
        }
        return result;
    }
}
