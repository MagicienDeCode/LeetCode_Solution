package easy_easy;

public class CountofMatchesinTournament1688 {
    public int numberOfMatches(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
                count += n;
            } else {
                count += n / 2;
                n = (n + 1) >> 1;
            }
        }
        return count;
    }
}
