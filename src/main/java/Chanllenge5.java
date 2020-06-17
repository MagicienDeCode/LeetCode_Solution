public class Chanllenge5 {
    /*
    public static long test(int n) {
        final List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        result.add(2);
        result.add(4);
        if (n <= 3) {
            return result.get(n);
        }
        int count = n - 3;
        while (count > 0) {
            final int size = result.size();
            final int sum = result.get(size - 1) + result.get(size - 2) + result.get(size - 3);
            result.add(sum);
            --count;
        }
        return result.get(result.size() - 1);
    }
     */
    public static long test(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        long long1 = 1L;
        long long2 = 2L;
        long long3 = 4L;
        int count = n - 3;
        while (count > 0) {
            final long sum = long1 + long2 + long3;
            long1 = long2;
            long2 = long3;
            long3 = sum;
            --count;
        }
        return long3;
    }

    public static void main(String[] args) {
        // 7
        System.out.println(Chanllenge5.test(4));
        // 274
        System.out.println(Chanllenge5.test(10));
        // 2555757
        System.out.println(Chanllenge5.test(25));
        // 10562230626642
        System.out.println(Chanllenge5.test(50));
    }
}
