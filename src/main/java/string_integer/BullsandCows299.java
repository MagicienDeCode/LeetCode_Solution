package string_integer;

public class BullsandCows299 {
    /*
    1 1 2 3     s
    0 1 1 1     g

    count[1] = 1
    count[0] = -1

    bulls = 1

    count[1] = 1 > 0 ==> cows = 1
    count[2] = 1
    count[1] = 0
     */
    public String getHint(String secret, String guess) {
        final int[] count = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            final int s = secret.charAt(i) - '0';
            final int g = guess.charAt(i) - '0';
            if (s == g) {
                ++bulls;
            } else {
                if (count[s] < 0) {
                    ++cows;
                }
                if (count[g] > 0) {
                    ++cows;
                }
                ++count[s];
                --count[g];
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        final BullsandCows299 java = new BullsandCows299();
        // 1A1B
        System.out.println(java.getHint("1123", "0111"));
    }
}
