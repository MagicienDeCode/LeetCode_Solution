package not_categorized_easy;

public class ShortestDistancetoaCharacter821 {
    public int[] shortestToChar(String s, char c) {
        final int[] result = new int[s.length()];
        int left = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                right = i;
                int distance = 0;
                if (left != -1) {
                    int start = left;
                    int end = right;
                    while (start <= end) {
                        result[start++] = distance;
                        result[end--] = distance;
                        distance++;
                    }
                } else {
                    int end = right;
                    while (end >= 0) {
                        result[end--] = distance++;
                    }
                }
                left = i;
            }
        }
        if (right != s.length() - 1) {
            int start = right;
            int distance = 0;
            while (start < s.length()) {
                result[start++] = distance++;
            }
        }
        return result;
    }
}
