package notcategorized;

public class ComplementofBase10Integer1009 {
    public int bitwiseComplement(int numN) {
        if (numN == 0) {
            return 1;
        }
        int flag = Integer.MAX_VALUE;
        while ((flag & numN) != 0) {
            flag <<= 1;
        }
        return ~flag & ~numN;
    }
}
