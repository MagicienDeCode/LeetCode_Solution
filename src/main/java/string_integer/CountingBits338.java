package string_integer;

public class CountingBits338 {
    public int[] countBits(int num) {
        final int[] result = new int[1 + num];
        for (int index = 0; index < result.length; index++) {
            result[index] = result[index >> 1] + (index % 2 == 0 ? 0 : 1);
        }
        return result;
    }
}
