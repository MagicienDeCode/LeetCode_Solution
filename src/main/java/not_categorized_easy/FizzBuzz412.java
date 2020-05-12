package not_categorized_easy;

import java.util.LinkedList;
import java.util.List;

public class FizzBuzz412 {
    public List<String> fizzBuzz(int n) {
        final List<String> result = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    result.add("FizzBuzz");
                } else {
                    result.add("Fizz");
                }
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
