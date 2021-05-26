package not_categorized;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers1689 {
    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            max = Math.max(c - '0', max);
        }
        return max;
    }
}
