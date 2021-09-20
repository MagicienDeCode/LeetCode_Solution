package list_array;

import java.util.Arrays;

public class OrderlyQueue899 {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); i++) {
                final String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        } else {
            final char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
