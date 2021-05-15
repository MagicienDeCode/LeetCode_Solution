package easy_easy;

import java.util.LinkedList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) {
            if (c > max) {
                max = c;
            }
        }
        final List<Boolean> results = new LinkedList<>();
        for (int c : candies) {
            if (c + extraCandies >= max) {
                results.add(true);
            } else {
                results.add(false);
            }
        }
        return results;
    }
}
