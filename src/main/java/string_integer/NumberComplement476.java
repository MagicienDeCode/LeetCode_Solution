package string_integer;

public class NumberComplement476 {

    public int findComplement(int num) {
        int mask = num;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        return num ^ mask;
    }

    /*
    public int findComplement(int num) {
        int flag = Integer.MAX_VALUE;
        while ((flag & num) != 0) {
            flag <<= 1;
        }
        return ~flag & ~num;
    }
    */
    public static void main(String... args) {
        int a = 5;
        int b = Integer.MAX_VALUE;
        int c = 0;
        while ((a & b) != 0) {
            b = b << 1;
            c++;
        }
        System.out.println(c);
    }
}
