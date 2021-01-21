package sliding_window;

import java.util.Arrays;

public class BoatstoSavePeople881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int end = people.length - 1;
        int start = 0;
        int result = 0;
        while (start <= end) {
            ++result;
            if (people[start] + people[end] <= limit) {
                ++start;
            }
            --end;
        }
        return result;
    }
}
