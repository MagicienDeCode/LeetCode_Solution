package list_array;

public class PushDominoes838 {
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char NONE = '0';

    public String pushDominoes(String dominoes) {
        final char[] chars = dominoes.toCharArray();
        char startDirection = NONE;
        char endDirection = NONE;
        int start;
        for (int end = 0; end < chars.length; end++) {
            if (chars[end] == '.') {
                start = end;
                if (start != 0) {
                    startDirection = chars[start - 1];
                }
                while (end < chars.length - 1 && chars[end + 1] == '.') {
                    ++end;
                }
                if (end < chars.length - 1) {
                    endDirection = chars[end + 1];
                }
                change(chars, start, end, startDirection, endDirection);
                startDirection = NONE;
                endDirection = NONE;
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void change(char[] chars, int start, int end, char startDirection, char endDirection) {
        if (startDirection == RIGHT && endDirection == LEFT) {
            while (start < end) {
                chars[start++] = RIGHT;
                chars[end--] = LEFT;
            }
        }
        // start
        else if (endDirection == LEFT) {
            for (int i = start; i <= end; i++) {
                chars[i] = LEFT;
            }
        }
        // end
        else if (startDirection == RIGHT) {
            for (int i = start; i <= end; i++) {
                chars[i] = RIGHT;
            }
        }
    }

    public static void main(String[] args) {
        final PushDominoes838 java = new PushDominoes838();
        System.out.println(java.pushDominoes(".L.R...LR..L.."));
        System.out.println(java.pushDominoes("RR.L"));
    }
}
