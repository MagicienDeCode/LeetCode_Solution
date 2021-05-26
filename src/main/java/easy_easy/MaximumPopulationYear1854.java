package easy_easy;

public class MaximumPopulationYear1854 {
    public int maximumPopulation(int[][] logs) {
        final int[] years = new int[101];
        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                years[i - 1950]++;
            }
        }
        int maxIndex = 101;
        int max = 0;
        for (int i = years.length - 1; i >= 0; i--) {
            if (years[i] >= max) {
                max = years[i];
                maxIndex = i;
            }
        }
        return maxIndex + 1950;
    }
}
