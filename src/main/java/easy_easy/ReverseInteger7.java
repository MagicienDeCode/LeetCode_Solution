package easy_easy;

public class ReverseInteger7 {
    public int reverse(int x) {
        int result = 0;
        int previous;
        while (x != 0) {
            previous = result;
            result = result * 10 + x % 10;
            x /= 10;
            if (result / 10 != previous) {
                return 0;
            }
        }
        return result;
    }
}
