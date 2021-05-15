package easy_easy;

public class DecodeXORedArray1720 {
    public int[] decode(int[] encoded, int first) {
        final int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = encoded[i] ^ result[i];
        }
        return result;
    }
}
