package string_integer;

/*
Instead of modelling the ray as a bouncing line, model it as a straight line through reflections of the room.
For example, if p = 2, q = 1, then we can reflect the room horizontally,
and draw a straight line from (0, 0) to (4, 2). The ray meets the receptor 2, which was reflected from (0, 2) to (4, 2).
In general, the ray goes to the first integer point (kp, kq) where k is an integer,
 and kp and kq are multiples of p. Thus, the goal is just to find the smallest k for which kq is a multiple of p.
The mathematical answer is k = p / gcd(p, q).
 */
public class MirrorReflection858 {

    public int mirrorReflection(int p, int q) {
        final int gcd = gcd(p, q);
        p /= gcd;
        p %= 2;
        q /= gcd;
        q %= 2;
        if (p == 1 && q == 1) {
            return 1;
        }
        return p == 1 ? 0 : 2;
    }

    // GCD, Greatest Common Divisor
    private int gcd(int a, int b) {
        if (a < b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        while (a % b != 0) {
            final int remainder = a % b;
            if (b < remainder) {
                a = remainder;
            } else {
                a = b;
                b = remainder;
            }
        }
        return b;
    }
}
