package easy_easy;

public class DIStringMatch942 {
    public int[] diStringMatch(String s) {
        final int[] result = new int[s.length() + 1];
        int right = s.length();
        int left = 0;
        for (int i = 0; i < result.length - 1; i++) {
            if (s.charAt(i) == 'D') {
                result[i] = right--;
            } else {
                result[i] = left++;
            }
        }
        result[s.length()] = left + 1;
        return result;
    }
}
