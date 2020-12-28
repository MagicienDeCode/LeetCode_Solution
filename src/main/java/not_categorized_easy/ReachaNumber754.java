package not_categorized_easy;

public class ReachaNumber754 {
    public int reachNumber(int target) {
        if (target == 0) {
            return 0;
        }
        target = target < 0 ? -target : target;
        int level = 1;
        int current = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            current += level;
            if (current >= target && (current - target) % 2 == 0) {
                return level;
            }
            ++level;
        }
        return -1;

        /*
        1: 0
        2: -1 1
        3: -3 -1 1 3
        4: -6 -4 -2 1 2 4 6
        5: -10 -8 -6 -4 -2 2 4 6 8 10
        6: -15 -13 -11 -9 -7 -5 -3 -1
        7: -21 -19 -17
         */
    }

    public static void main(String[] args) {
        final ReachaNumber754 java = new ReachaNumber754();
        // 2
        System.out.println(java.reachNumber(3));
        // 3
        System.out.println(java.reachNumber(2));
        //
        System.out.println(java.reachNumber(-1000000000));
    }
}
