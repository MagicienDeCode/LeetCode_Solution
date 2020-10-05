package not_categorized;

public class ComplementofBase10Integer1009 {
    // Also see NumberComplementKotlin476
    /*
    5 => 101
    flag => 111 (32)

    after while
    flag => 111...(29)000

    ~5 => 11111(29)010
    ~flag => 00(29)111

    result => 00000(30)10 => 2

     */
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
