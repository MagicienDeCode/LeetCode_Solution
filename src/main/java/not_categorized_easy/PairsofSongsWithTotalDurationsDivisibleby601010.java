package not_categorized_easy;

public class PairsofSongsWithTotalDurationsDivisibleby601010 {
    public int numPairsDivisibleBy60(int[] time) {
        final int[] temp = new int[60];
        int result = 0;
        for (int t : time) {
            if (t % 60 == 0) {
                result += temp[0];
            } else {
                result += temp[60 - t % 60];
            }
            temp[t % 60]++;
        }
        return result;
    }
    /* Time Limit Exceeded
    public int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    ++result;
                }
            }
        }
        return result;
    }
     */
}
