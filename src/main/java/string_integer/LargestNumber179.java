package string_integer;

import java.util.Arrays;

public class LargestNumber179 {
    public String largestNumber(int[] nums) {
        final String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (s1, s2) -> {
            final String order1 = s1 + s2;
            final String order2 = s2 + s1;
            return order2.compareTo(order1);
        });

        if (strings[0].equals("0")) {
            return "0";
        }

        final StringBuilder result = new StringBuilder();
        for (String s : strings) {
            result.append(s);
        }
        return result.toString();
    }
}
