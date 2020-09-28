package string_integer;

public class TeemoAttacking495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            result += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return result + duration;
    }
}
