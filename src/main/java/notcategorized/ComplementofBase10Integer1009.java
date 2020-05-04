package notcategorized;

public class ComplementofBase10Integer1009 {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int flag = Integer.MAX_VALUE;
        while ((flag & N) != 0) {
            flag <<= 1;
        }
        return ~flag & ~N;
    }
}
