package not_categorized;

public class PoorPigs458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        long num = 1;
        while (num < buckets) {
            num *= rounds;
            ++pigs;
        }
        return pigs;
        // return log(buckets-1) / log(rounds) + 1;
    }
}
