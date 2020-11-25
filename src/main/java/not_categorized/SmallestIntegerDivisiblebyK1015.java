package not_categorized;

public class SmallestIntegerDivisiblebyK1015 {
    /*
    remainder = 1
    length_N = 1

    while remainder%K != 0
        N = remainder*10 + 1
        remainder = N%K
        length_N += 1

    return length_N
     */
    public int smallestRepunitDivByK(int k) {
        int remainder = 0;
        for (int i = 1; i <= k; i++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                return i;
            }
        }
        return -1;
    }
}
